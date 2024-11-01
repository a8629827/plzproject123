package com.lyj.securitydomo.dto;

import com.lyj.securitydomo.domain.User;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class UserDTO {
    private Long userId;               // 고유 식별자
    private String name;               // 사용자 이름
    private String username;           // 사용자 아이디
    private String email;              // 이메일
    private String birthDate;          // 생일
    private int gender;                // 성별
    private String role;               // 권한
    private String address;            // 거주 지역
    private LocalDateTime regDate;     // 회원가입 날짜

    // Entity -> DTO 변환 메서드
    public static UserDTO fromEntity(User user) {
        return UserDTO.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .birthDate(user.getBirthDate())
                .gender(user.getGender())
                .role(user.getRole())
                .address(user.getAddress())
                .regDate(user.getRegDate())
                .build();
    }

    // DTO -> Entity 변환 메서드
    public User toEntity() {
        return User.builder()
                .userId(this.userId)
                .name(this.name)
                .username(this.username)
                .email(this.email)
                .birthDate(this.birthDate)
                .gender(this.gender)
                .role(this.role)
                .address(this.address)
                .regDate(this.regDate)
                .build();
    }
}
