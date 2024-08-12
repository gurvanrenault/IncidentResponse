package com.incidentresponse.domain.services;

import com.incidentresponse.domain.interfaces.IIncidentService;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.infrastructure.entity.IncidentEntity;
import com.incidentresponse.infrastructure.mapper.IncidentEntityMapper;
import com.incidentresponse.infrastructure.repository.interfaces.IIncidentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IncidentService implements IIncidentService {


    private final IIncidentRepository incidentRepository;
    private final IncidentEntityMapper incidentEntityMapper;
    private final int SIZE_PAGE = 10;

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

    @Override
    public Incident getIncident(Long id) {
        Optional<IncidentEntity> optionalIncidentEntity = incidentRepository.findById(id);
        return optionalIncidentEntity.map(this.incidentEntityMapper::entityToDomain).orElse(null);
    }

    @Override
    public boolean deleteIncident(Long id) {
        Incident incident = this.getIncident(id);
        if (incident != null) {
            this.incidentRepository.delete(this.incidentEntityMapper.domainToEntity(incident));
            return true;
        }
        return false;
    }

    @Override
    public Incident updateIncident(Incident incident) {

        Incident incidentRetrieved = this.getIncident(incident.getId());
        if (incidentRetrieved != null) {
            incident.setDate(incidentRetrieved.getDate());
            IncidentEntity iEntity = this.incidentRepository.save(this.incidentEntityMapper.domainToEntity(incident));
            return this.incidentEntityMapper.entityToDomain(iEntity);
        }
        return null;
    }

    @Override
    public List<Incident> getAllIncidents(int page) {
        if (page < 0) {
            return new ArrayList<>();
        }
        PageRequest pageRequest = PageRequest.of(page, SIZE_PAGE);
        Page<IncidentEntity> incidentsPage = this.incidentRepository.findAll(pageRequest);

        return this.incidentEntityMapper.listEntityToDomain(incidentsPage.getContent());
    }
}
