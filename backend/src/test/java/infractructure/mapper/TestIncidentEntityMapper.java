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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
        Assertions.assertEquals(42L, incident.getId());
        Assertions.assertNotNull(incident.getDescription());
        Assertions.assertEquals(PriorityStatusEnum.P1, incident.getPriority());
        Assertions.assertEquals(StatusIncidentEnum.TO_DO, incident.getStatus());
        Assertions.assertNotNull(incident.getTitle());
        Assertions.assertNotNull(incident.getDate());
        Assertions.assertNotNull(incident.getUserAssignated());

    }


    @Test
    public void testDomainToEntity() {
        Incident incident = this.generateIncident();
        IncidentEntity incidentEntity = this.incidentEntityMapper.domainToEntity(incident);
        Assertions.assertEquals(42L, incidentEntity.getId());
        Assertions.assertNotNull(incidentEntity.getDescription());
        Assertions.assertEquals(PriorityStatusEnum.P1, incidentEntity.getPriority());
        Assertions.assertEquals(StatusIncidentEnum.TO_DO, incidentEntity.getStatus());
        Assertions.assertNotNull(incidentEntity.getTitle());
        Assertions.assertNotNull(incidentEntity.getDate());
        Assertions.assertNotNull(incidentEntity.getUserAssignated());

    }

    @Test
    public void testListEntityToDomain() {
        IncidentEntity[] incidentsArray = new IncidentEntity[]{this.generateIncidentEntity()};
        List<IncidentEntity> incidentsEntities = Arrays.asList(incidentsArray);
        List<Incident> incidents = this.incidentEntityMapper.listEntityToDomain(incidentsEntities);
        Assertions.assertEquals(1, incidents.size());
        Assertions.assertEquals(42L, incidents.getFirst().getId());
        Assertions.assertNotNull(incidents.getFirst().getDescription());
        Assertions.assertEquals(PriorityStatusEnum.P1, incidents.getFirst().getPriority());
        Assertions.assertEquals(StatusIncidentEnum.TO_DO, incidents.getFirst().getStatus());
        Assertions.assertNotNull(incidents.getFirst().getTitle());
        Assertions.assertNotNull(incidents.getFirst().getDate());
        Assertions.assertNotNull(incidents.getFirst().getUserAssignated());

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
