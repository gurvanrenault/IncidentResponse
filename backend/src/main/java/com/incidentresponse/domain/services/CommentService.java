package com.incidentresponse.domain.services;

import com.incidentresponse.domain.interfaces.ICommentService;
import com.incidentresponse.domain.model.Comment;
import com.incidentresponse.infrastructure.entity.CommentEntity;
import com.incidentresponse.infrastructure.mapper.CommentEntityMapper;
import com.incidentresponse.infrastructure.repository.interfaces.ICommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService {


    private final ICommentRepository commentRepository;
    private final CommentEntityMapper commentEntityMapper;

    public CommentService(ICommentRepository commentRepository, CommentEntityMapper commentEntityMapper) {
        this.commentRepository = commentRepository;
        this.commentEntityMapper = commentEntityMapper;
    }

    @Override
    public Comment addComment(Comment comment) {
        CommentEntity comEntity = this.commentRepository.save(this.commentEntityMapper.domainToEntity(comment));
        return this.commentEntityMapper.entityToDomain(comEntity);
    }
}
