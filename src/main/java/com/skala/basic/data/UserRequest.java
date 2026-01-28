package com.skala.basic.data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRequest {
    
    @NotEmpty
    private String userId;

    @NotEmpty
    private String userName;

    @Pattern(regexp = "^[mf]$", message = "Gender must be 'm' or 'f'")
    private String userGender;


    private String userPhone;

}