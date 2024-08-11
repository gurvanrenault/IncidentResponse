package infractructure.mapper;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.domain.model.User;
import com.incidentresponse.enums.PriorityStatusEnum;
import com.incidentresponse.enums.StatusIncidentEnum;
import com.incidentresponse.infrastructure.entity.IncidentEntity;
import com.incidentresponse.infrastructure.entity.UserEntity;
import com.incidentresponse.infrastructure.mapper.IncidentEntityMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = IncidentApplication.class)
public class TestIncidentEntityMapper {

    private final IncidentEntityMapper incidentEntityMapper;

    @Autowired
    public TestIncidentEntityMapper(IncidentEntityMapper incidentDTOMapper) {
        this.incidentEntityMapper = incidentDTOMapper;
    }

    @Test
    public void testEntityToDomain() {
        IncidentEntity incidentEntity = this.generateIncidentEntity();
        Incident incident = this.incidentEntityMapper.entityToDomain(incidentEntity);
        assertEquals(42L, incident.getId());
        assertNotNull(incident.getDescription());
        assertEquals(PriorityStatusEnum.P1, incident.getPriority());
        assertEquals(StatusIncidentEnum.TO_DO, incident.getStatus());
        assertNotNull(incident.getTitle());
        assertNotNull(incident.getDate());
        assertNotNull(incident.getUserAssignated());

    }


    @Test
    public void testDomainToEntity() {
        Incident incident = this.generateIncident();
        IncidentEntity incidentEntity = this.incidentEntityMapper.domainToEntity(incident);
        assertEquals(42L, incidentEntity.getId());
        assertNotNull(incidentEntity.getDescription());
        assertEquals(PriorityStatusEnum.P1, incidentEntity.getPriority());
        assertEquals(StatusIncidentEnum.TO_DO, incidentEntity.getStatus());
        assertNotNull(incidentEntity.getTitle());
        assertNotNull(incidentEntity.getDate());
        assertNotNull(incidentEntity.getUserAssignated());

    }

    @Test
    public void testListEntityToDomain() {
        IncidentEntity[] incidentsArray = new IncidentEntity[]{this.generateIncidentEntity()};
        List<IncidentEntity> incidentsEntities = Arrays.asList(incidentsArray);
        List<Incident> incidents = this.incidentEntityMapper.listEntityToDomain(incidentsEntities);
        assertEquals(1, incidents.size());
        assertEquals(42L, incidents.getFirst().getId());
        assertNotNull(incidents.getFirst().getDescription());
        assertEquals(PriorityStatusEnum.P1, incidents.getFirst().getPriority());
        assertEquals(StatusIncidentEnum.TO_DO, incidents.getFirst().getStatus());
        assertNotNull(incidents.getFirst().getTitle());
        assertNotNull(incidents.getFirst().getDate());
        assertNotNull(incidents.getFirst().getUserAssignated());

    }

    /**
     * Generate an incident
     *
     * @return an incident
     */
    private Incident generateIncident() {
        Incident incident = new Incident();
        incident.setId(42L);
        incident.setDescription(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        incident.setPriority(PriorityStatusEnum.P1);
        incident.setStatus(StatusIncidentEnum.TO_DO);
        incident.setTitle(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        incident.setDate(new Date());
        incident.setCommentaries(new ArrayList<>());
        incident.setUserAssignated(new User());
        return incident;
    }

    /**
     * Generate an incident entity
     *
     * @return a random incident entity
     */
    private IncidentEntity generateIncidentEntity() {
        IncidentEntity incident = new IncidentEntity();
        incident.setId(42L);
        incident.setDescription(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        incident.setPriority(PriorityStatusEnum.P1);
        incident.setStatus(StatusIncidentEnum.TO_DO);
        incident.setTitle(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        incident.setDate(new Date());
        incident.setUserAssignated(new UserEntity());
        return incident;
    }
}
