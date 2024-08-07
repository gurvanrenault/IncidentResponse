package com.incidentresponse.domain.services;

import com.incidentresponse.domain.interfaces.IIncidentService;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.infrastructure.entity.IncidentEntity;
import com.incidentresponse.infrastructure.mapper.IncidentEntityMapper;
import com.incidentresponse.infrastructure.repository.interfaces.IIncidentRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class IncidentService implements IIncidentService {


    private IIncidentRepository incidentRepository;
    private IncidentEntityMapper incidentEntityMapper;

    public IncidentService(IIncidentRepository incidentRepository, IncidentEntityMapper incidentEntityMapper) {
        this.incidentRepository = incidentRepository;
        this.incidentEntityMapper = incidentEntityMapper;
    }


    @Override
    public Incident addIncident(Incident incident) {
        incident.setDate(Timestamp.from(Instant.now()));
        IncidentEntity incidentEntity = incidentRepository.save(incidentEntityMapper.domainToEntity(incident));
        return this.incidentEntityMapper.entityToDomain(incidentEntity);
    }
}
