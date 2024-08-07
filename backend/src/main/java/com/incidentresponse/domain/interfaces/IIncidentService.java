package com.incidentresponse.domain.interfaces;

import com.incidentresponse.domain.model.Incident;

public interface IIncidentService {

    Incident addIncident(Incident incident);

    Incident getIncident(Long id);
}
