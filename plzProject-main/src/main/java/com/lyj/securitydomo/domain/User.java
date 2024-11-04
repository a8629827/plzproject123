package com.lyj.securitydomo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="user")
@Builder
public class User {

    @Id
    @ColumnDefault("0")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; //고유 식별자

    @Column(length = 50, nullable = true)
    private String name; //이름

    @Column(length = 50, nullable = true, unique = true)
    private String username; //ID

    @Column(length = 255, nullable = true)
    private String password; //비밀번호

    @Column(length = 100, nullable = true)
    private String email; //이메일

    @Column(nullable = false)
    private LocalDate birthDate; //생일
    private String gender; //성별
    private String role; //권한
    private String address; //지역

    @CreationTimestamp
    @Column(name="regdate", updatable = false)
    private LocalDateTime regDate; //회원가입 날짜

//    @ColumnDefault("0")
//    private Long visitCount; //방문 횟수

}