package com.incidentresponse.application.mapper;

import com.incidentresponse.application.dto.IncidentDTO;
import com.incidentresponse.domain.model.Incident;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IncidentDTOMapper {

    IncidentDTO domainToApplication(Incident incident);

    Incident applicationToDomain(IncidentDTO incidentDTO);

    List<IncidentDTO> listDomainToApplication(List<Incident> incident);
}
