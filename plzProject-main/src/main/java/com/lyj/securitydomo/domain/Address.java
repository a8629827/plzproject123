package com.lyj.securitydomo.domain;


import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Entity(name="address")
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")  // userId는 User 테이블의 PK
    private User address;  // 사용자 엔티티와 연관

    private String city; // 00시
    private String state; // 00구



}
