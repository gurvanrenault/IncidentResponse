package com.incidentresponse.application.mapper;

import com.incidentresponse.application.dto.CommentaryDTO;
import com.incidentresponse.domain.model.Commentary;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentaryDTOMapper {
    CommentaryDTO domainToApplication(Commentary commentary);

    Commentary applicationToDomain(CommentaryDTO commentaryDTO);
}
