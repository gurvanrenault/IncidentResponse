package com.incidentresponse.application.mapper;

import com.incidentresponse.application.dto.IncidentDTO;
import com.incidentresponse.domain.model.Incident;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IncidentDTOMapper {

    IncidentDTO domainToApplication(Incident incident);

    Incident applicationToDomain(IncidentDTO incidentDTO);
}
