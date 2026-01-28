package com.skala.basic.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skala.basic.data.UserRequest;
import com.skala.basic.data.UserResponse;


@RestController
public class UserController { 

    private final Map<String, UserRequest> userMap = new HashMap<>();

    @PostMapping("/users")
    public UserResponse postUsers(@RequestBody @Validated UserRequest requestBody) {

        userMap.put(requestBody.getUserId(), requestBody);

        UserResponse responseBody = new UserResponse();
        responseBody.setResultCode(UserResponse.SUCCESS);
        responseBody.setResultMessage("사용자가 정상적으로 등록되었습니다.");
        responseBody.setRequest(requestBody);

        return responseBody;
    }

    @GetMapping("/users")
    public List<UserRequest> getUsers() {
        List<UserRequest> list = new ArrayList<>(userMap.values());

        return list;
    }

}