package com.skala.basic.table;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity // 1. JPA가 관리하는 엔티티 객체임을 선언 (DB 테이블과 매핑)
@Data   // Getter, Setter, toString 등 자동 생성
@Table(name = "users") // 2. 실제 DB 테이블 이름을 "users"로 지정
public class User {

    @Id // 3. 기본키(Primary Key) 설정
    private String userId;
    
    private String userName;
    private String userGender;
    private String userPhone;

    private Date createdAt; // 생성 일시

}