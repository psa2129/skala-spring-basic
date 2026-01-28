package com.skala.basic.table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class User {
    
    @Id
    private String userId;

    private String userName;
    private String userGender;
    private String userPhone;

}