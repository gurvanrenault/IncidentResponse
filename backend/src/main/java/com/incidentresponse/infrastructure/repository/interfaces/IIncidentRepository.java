package com.incidentresponse.infrastructure.repository.interfaces;

import com.incidentresponse.infrastructure.entity.IncidentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIncidentRepository extends JpaRepository<IncidentEntity, Long> {

}
