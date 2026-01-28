package com.skala.basic.data;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data // 1. Getter, Setter, toString, EqualsAndHashCode 등 자동 생성
public class UserRequest {
    
    @NotEmpty(message = "ID는 필수 항목임") // 2. 빈 값(null, "") 허용 안 함
    private String userId;

    @NotEmpty(message = "이름은 필수 항목임") // 3. 빈 값 허용 안 함
    private String userName;

    // 4. 정규식을 이용한 성별 값 제한 (m 또는 f만 가능)
    @Pattern(regexp = "^[mf]$", message = "성별은 'm' 또는 'f'만 입력 가능함")
    private String userGender;

    private String userPhone; // 별도 제약 조건 없음 (선택 사항)

}