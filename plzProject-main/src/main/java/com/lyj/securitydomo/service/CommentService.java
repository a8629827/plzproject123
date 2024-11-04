package com.lyj.securitydomo.service;

import com.lyj.securitydomo.domain.Comment;

import java.util.List;

public interface CommentService {
    public Comment saveComment(Comment comment);
    public Comment addReply(Long paretId, Comment comment);
    public List<Comment> getReplies(Long paretId);
    public List<Comment> getTopComments(Long board_id);
    public void deleteComment(Long comment_id);
}
