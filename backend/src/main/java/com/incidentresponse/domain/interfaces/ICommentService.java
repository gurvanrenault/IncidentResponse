package com.incidentresponse.domain.interfaces;

import com.incidentresponse.domain.model.Comment;

import java.util.List;

public interface ICommentService {

    Comment addComment(Comment comment);

    Comment updateComment(Comment comment);

    List<Comment> getCommentsByIdIncident(Long idIncident);
}
