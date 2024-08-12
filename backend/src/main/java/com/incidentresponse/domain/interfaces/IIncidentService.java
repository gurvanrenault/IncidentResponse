package com.incidentresponse.domain.interfaces;

import com.incidentresponse.domain.model.Incident;

import java.util.List;
public interface IIncidentService {

    Incident addIncident(Incident incident);

    Incident getIncident(Long id);

    boolean deleteIncident(Long id);

    Incident updateIncident(Incident incident);

    List<Incident> getAllIncidents(int page);
}
