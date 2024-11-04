package com.lyj.securitydomo.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="gender")
@Builder
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genderId;

    @Column(length = 20)
    private String genderName;

//    @ManyToOne(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            optional = true)
//    @JoinColumn(name="user_id")
//    private User user;
//    public void updateHitcount() {
//        this.hitcount = this.hitcount+1;
//    }

}
