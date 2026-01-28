package com.skala.basic.data;

import lombok.Data;

@Data // Getter, Setter 등 자동 생성
public class UserResponse {
    // 1. 상태 코드 상수화 (가독성 및 유지보수 업)
    public static final int SUCCESS = 0;
    public static final int FAIL = -1;

    private int resultCode;      // 실행 결과 코드 (0 또는 -1)
    private String resultMessage; // 실행 결과 메시지 (ex: "성공", "에러발생")
    
    private UserRequest request; // 2. 클라이언트가 보냈던 요청 데이터를 다시 담아서 보냄

}