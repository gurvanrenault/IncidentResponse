package com.incidentresponse.infrastructure.mapper;

import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.infrastructure.entity.IncidentEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncidentEntityMapper {
    IncidentEntity domainToEntity(Incident i);

    Incident entityToDomain(IncidentEntity iEntity);
}
