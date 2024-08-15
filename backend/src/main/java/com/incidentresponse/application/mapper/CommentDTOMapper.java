package com.incidentresponse.application.mapper;

import com.incidentresponse.application.dto.CommentDTO;
import com.incidentresponse.domain.model.Comment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommentDTOMapper {
    CommentDTO domainToApplication(Comment commentary);

    Comment applicationToDomain(CommentDTO commentDTO);

    List<CommentDTO> listDomainToApplication(List<Comment> comments);
}
