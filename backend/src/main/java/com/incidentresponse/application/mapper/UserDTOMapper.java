package com.incidentresponse.application.mapper;

import com.incidentresponse.application.dto.UserDTO;
import com.incidentresponse.domain.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOMapper {
    UserDTO domainToApplication(User user);

    User applicationToDomain(UserDTO userDTO);
}
