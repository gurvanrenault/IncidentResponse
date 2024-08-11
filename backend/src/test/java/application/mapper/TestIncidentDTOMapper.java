package application.mapper;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.application.dto.IncidentDTO;
import com.incidentresponse.application.dto.UserDTO;
import com.incidentresponse.application.mapper.IncidentDTOMapper;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.domain.model.User;
import com.incidentresponse.enums.PriorityStatusEnum;
import com.incidentresponse.enums.StatusIncidentEnum;
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
public class TestIncidentDTOMapper {

    private final IncidentDTOMapper incidentDTOMapper;

    @Autowired
    public TestIncidentDTOMapper(IncidentDTOMapper incidentDTOMapper) {
        this.incidentDTOMapper = incidentDTOMapper;
    }

    @Test
    public void testApplicationToDomain() {
        IncidentDTO incidentDTO = this.generateIncidentDTO();
        Incident incident = this.incidentDTOMapper.applicationToDomain(incidentDTO);
        assertEquals(42L, incident.getId());
        assertNotNull(incident.getDescription());
        assertEquals(PriorityStatusEnum.P1, incident.getPriority());
        assertEquals(StatusIncidentEnum.TO_DO, incident.getStatus());
        assertNotNull(incident.getTitle());
        assertNotNull(incident.getDate());
        assertNotNull(incident.getCommentaries());
        assertNotNull(incident.getUserAssignated());

    }


    @Test
    public void testDomainToApplication() {
        Incident incident = this.generateIncident();
        IncidentDTO incidentDTO = this.incidentDTOMapper.domainToApplication(incident);
        assertEquals(42L, incidentDTO.getId());
        assertNotNull(incidentDTO.getDescription());
        assertEquals(PriorityStatusEnum.P1, incidentDTO.getPriority());
        assertEquals(StatusIncidentEnum.TO_DO, incidentDTO.getStatus());
        assertNotNull(incidentDTO.getTitle());
        assertNotNull(incidentDTO.getDate());
        assertNotNull(incidentDTO.getCommentaries());
        assertNotNull(incidentDTO.getUserAssignated());

    }

    @Test
    public void testListDomainToApplication() {
        Incident[] incidentsArray = new Incident[]{this.generateIncident()};
        List<Incident> incidents = Arrays.asList(incidentsArray);
        List<IncidentDTO> incidentsDTO = this.incidentDTOMapper.listDomainToApplication(incidents);
        assertEquals(1, incidentsDTO.size());
        assertEquals(42L, incidentsDTO.getFirst().getId());
        assertNotNull(incidentsDTO.getFirst().getDescription());
        assertEquals(PriorityStatusEnum.P1, incidentsDTO.getFirst().getPriority());
        assertEquals(StatusIncidentEnum.TO_DO, incidentsDTO.getFirst().getStatus());
        assertNotNull(incidentsDTO.getFirst().getTitle());
        assertNotNull(incidentsDTO.getFirst().getDate());
        assertNotNull(incidentsDTO.getFirst().getCommentaries());
        assertNotNull(incidentsDTO.getFirst().getUserAssignated());

    }


    /**
     * Generate an incident DTO
     *
     * @return an incident DTO
     */
    private IncidentDTO generateIncidentDTO() {
        IncidentDTO incident = new IncidentDTO();
        incident.setId(42L);
        incident.setDescription(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        incident.setPriority(PriorityStatusEnum.P1);
        incident.setStatus(StatusIncidentEnum.TO_DO);
        incident.setTitle(RandomStringUtils.randomAlphanumeric(17).toUpperCase());
        incident.setDate(new Date());
        incident.setCommentaries(new ArrayList<>());
        incident.setUserAssignated(new UserDTO());
        return incident;

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
}
