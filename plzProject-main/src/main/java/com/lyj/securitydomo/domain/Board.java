package com.lyj.securitydomo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Getter
@Setter
@Entity(name="tbl_board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;
    private String title;
    private String writer; //엔티티에틑 보통 안쓴다(DTO가 없어서 생성한것임.) 조금 편하게 하려고.
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="regdate")
    private Date regdate;

    //@ColumnDefault("0")
    private Long hitcount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    @PrePersist
    public void prePersist(){
        this.hitcount=this.hitcount==null?0:this.hitcount+1;
    }
//    public void updateHitcount() {
//        this.hitcount = this.hitcount+1;
//    }
}