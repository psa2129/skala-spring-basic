package com.skala.basic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skala.basic.table.User;

@Repository // 1. DB 접근 클래스임을 명시 (Bean 등록)
public interface UserRepository extends JpaRepository<User, String> {
    
    // 2. 쿼리 메소드: 이름에 특정 문자열이 포함된 사용자 목록 조회
    // SQL: SELECT * FROM user WHERE user_name LIKE '%name%'
    List<User> findByUserNameContaining(String name);
}