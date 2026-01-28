package com.skala.basic.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skala.basic.data.UserRequest;
import com.skala.basic.data.UserResponse;
import com.skala.basic.repository.UserRepository;
import com.skala.basic.table.User;

import lombok.RequiredArgsConstructor;

@Service // 1. 비즈니스 로직을 수행하는 서비스 빈(Bean) 등록
@RequiredArgsConstructor // Repository 주입을 위한 생성자 자동 생성
public class UserService {
    private final UserRepository userRepository;

    /**
     * 사용자 생성 로직
     */
    public UserResponse createUser(UserRequest requestBody) {
        // 2. 중복 체크: 이미 존재하는 ID인지 확인
        boolean isUserExists = userRepository.existsById(requestBody.getUserId());
        if(isUserExists) {
            UserResponse responseBody = new UserResponse();
            responseBody.setResultCode(UserResponse.FAIL); // 실패 코드(-1)
            responseBody.setResultMessage("이미 존재하는 사용자 ID입니다.");
            responseBody.setRequest(requestBody);
            return responseBody;
        }

        // 3. DTO -> Entity 변환 및 데이터 설정
        User user = new User();
        user.setUserId(requestBody.getUserId());
        user.setUserName(requestBody.getUserName());
        user.setUserGender(requestBody.getUserGender());
        user.setUserPhone(requestBody.getUserPhone());
        user.setCreatedAt(new Date()); // 현재 시간 기록

        // 4. DB 저장
        userRepository.save(user);

        // 5. 성공 응답 생성
        UserResponse responseBody = new UserResponse();
        responseBody.setResultCode(UserResponse.SUCCESS); // 성공 코드(0)
        responseBody.setResultMessage("사용자가 정상적으로 등록되었습니다.");
        responseBody.setRequest(requestBody);

        return responseBody;    
    }
    
    // 전체 조회: 레포지토리의 findAll() 활용
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // 이름 검색: 레포지토리의 커스텀 메서드 활용
    public List<User> getUsersByName(String name) {
        return userRepository.findByUserNameContaining(name);
    }
}