package com.lyj.securitydomo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;


@Data
@Entity(name="tbl_comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    @ManyToOne
    @JoinColumn(name="board_id")
    Board board;

    @ManyToOne(fetch = FetchType.LAZY) //대댓글
    @JoinColumn(name="parent_id")
    Comment parent;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
    private List<Comment> children;

    public void addChild(Comment child) {
        child.setParent(this);
        this.children.add(child);
    }

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long cnum;
//    private String content;
//    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat(pattern ="yyyy-MM-dd")
//    private Date regdate;

//    @ManyToOne
//    @JoinColumn(name = "bnum")
//    private Board board;
//
//    @ManyToOne
//    @JoinColumn(name ="user_id")
//    private User user;
}
