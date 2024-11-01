package com.lyj.securitydomo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="role")
@Builder
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(length = 20)
    private String role_name;

//    @ManyToOne(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            optional = true)
//    @JoinColumn(name="user_id")
//    private User user;
//
//    public void updateHitcount() {
//        this.hitcount = this.hitcount+1;
//    }

}
