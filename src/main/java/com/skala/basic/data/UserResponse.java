package com.skala.basic.data;

import lombok.Data;

@Data
public class UserResponse {
    public static final int SUCCESS = 0;
    public static final int FAIL = -1;

    private int resultCode;
    private String resultMessage;
    
    private UserRequest request;

}