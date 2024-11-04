package com.lyj.securitydomo.repository;

import com.lyj.securitydomo.domain.Board;
import com.lyj.securitydomo.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardAndParentIsNull(Board board);
    List<Comment> findByParentId(Long parentId);
}
