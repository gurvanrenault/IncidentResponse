package com.incidentresponse.infrastructure.mapper;


import com.incidentresponse.domain.model.Comment;
import com.incidentresponse.infrastructure.entity.CommentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentEntityMapper {
    CommentEntity domainToEntity(Comment commentary);

    Comment entityToDomain(CommentEntity commentaryEntity);

    List<Comment> listEntityToDomain(List<CommentEntity> commentEntities);
}


