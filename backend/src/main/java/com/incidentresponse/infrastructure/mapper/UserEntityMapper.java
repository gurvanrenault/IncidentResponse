package com.incidentresponse.infrastructure.mapper;

import com.incidentresponse.domain.model.User;
import com.incidentresponse.infrastructure.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {
    UserEntity domainToEntity(User user);

    User entityToDomain(UserEntity userEntity);
}
