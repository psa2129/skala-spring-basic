package com.skala.basic.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skala.basic.data.UserRequest;
import com.skala.basic.data.UserResponse;
import com.skala.basic.service.UserService;
import com.skala.basic.table.User;

import lombok.RequiredArgsConstructor;

@RestController // JSON 응답을 처리하는 REST API 컨트롤러 선언
@RequiredArgsConstructor // final 필드(userService)에 대한 생성자 자동 생성 (의존성 주입)
public class UserController {

    private final UserService userService;

    /**
     * 사용자 등록 API
     * @RequestBody: JSON 데이터를 UserRequest 객체로 매핑
     * @Validated: 입력 데이터 유효성 검증 수행
     */
    @PostMapping("/users")
    public UserResponse postUsers(@RequestBody @Validated UserRequest requestBody) {
        // 서비스 계층에 유저 생성 위임 및 결과 반환
        return userService.createUser(requestBody);
    }

    /**
     * 사용자 목록 조회 API (전체 조회 및 이름 검색 통합)
     * @RequestParam: URL 파라미터(?name=...) 처리, 필수값 아님(required = false)
     */
    @GetMapping("/users")
    public List<User> getUsers(@RequestParam(required = false) String name) {
        // 이름(name) 파라미터가 비어있지 않은 경우
        if (name != null && !name.isEmpty()) {
            System.out.println("name: " + name); // 콘솔에 검색어 출력 (디버깅용)
            return userService.getUsersByName(name); // 이름으로 필터링된 목록 반환
        }
        
        // 파라미터가 없으면 전체 사용자 목록 반환
        return userService.getAllUsers();
    }
}