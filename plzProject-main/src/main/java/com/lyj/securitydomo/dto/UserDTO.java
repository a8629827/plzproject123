package com.lyj.securitydomo.dto;

import com.lyj.securitydomo.domain.User;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public class UserDTO {
    private Long userId;               // 고유 식별자
    private String name;               // 사용자 이름
    private String username;           // 사용자 아이디
    private String email;              // 이메일
    private LocalDate birthDate;          // 생일
    private String gender;                // 성별
    private String role;               // 권한
    private String address;            // 거주 지역
    private LocalDateTime regDate;     // 회원가입 날짜
}
