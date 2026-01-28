package com.skala.basic.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skala.basic.data.UserRequest;
import com.skala.basic.data.UserResponse;
import com.skala.basic.repository.UserRepository;
import com.skala.basic.table.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserResponse createUser(UserRequest requestBody) {

        boolean isUserExists = userRepository.existsById(requestBody.getUserId());
        if(isUserExists) {
            UserResponse responseBody = new UserResponse();
            responseBody.setResultCode(UserResponse.FAIL);
            responseBody.setResultMessage("이미 존재하는 사용자 ID입니다.");
            responseBody.setRequest(requestBody);
            return responseBody;
        }

        User user = new User();
        user.setUserId(requestBody.getUserId());
        user.setUserName(requestBody.getUserName());
        user.setUserGender(requestBody.getUserGender());
        user.setUserPhone(requestBody.getUserPhone());
        user.setCreatedAt(new Date());

        userRepository.save(user);

        UserResponse responseBody = new UserResponse();
        responseBody.setResultCode(UserResponse.SUCCESS);
        responseBody.setResultMessage("사용자가 정상적으로 등록되었습니다.");
        responseBody.setRequest(requestBody);

        return responseBody;    
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByName(String name) {
        // Assuming you have a method in UserRepository to find users by name
        return userRepository.findByUserNameContaining(name);
    }
}