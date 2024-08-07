package domain;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.domain.model.User;
import com.incidentresponse.domain.services.IncidentService;
import com.incidentresponse.enums.PriorityStatusEnum;
import com.incidentresponse.enums.StatusIncidentEnum;
import com.incidentresponse.infrastructure.entity.IncidentEntity;
import com.incidentresponse.infrastructure.mapper.IncidentEntityMapper;
import com.incidentresponse.infrastructure.repository.interfaces.IIncidentRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = IncidentApplication.class)
public class TestIncidentService {

    private final Long ID_EXIST = 42L;
    private final Long ID_NOT_EXIST = 4L;
    @Spy
    IncidentEntityMapper incidentEntityMapper;
    @Mock
    private IIncidentRepository incidentRepository;
    @InjectMocks
    private IncidentService incidentService;

    @BeforeEach
    public void beforeEach() {
        when(incidentRepository.save(any())).thenReturn(new IncidentEntity());
        when(incidentRepository.findById(ID_NOT_EXIST)).thenReturn(Optional.empty());
        when(incidentRepository.findById(ID_EXIST)).thenReturn(Optional.of(new IncidentEntity()));
        when(incidentEntityMapper.entityToDomain(any())).thenReturn(new Incident());
    }

    @Test
    public void testAddIncident() {
        Incident incident = generateIncident();
        assertNotNull(this.incidentService.addIncident(incident));
    }

    @Test
    public void testGetIncidentExist() {
        System.out.println(this.incidentService.getIncident(ID_EXIST));
        assertNotNull(this.incidentService.getIncident(ID_EXIST));
    }

    @Test
    public void testGetIncidentNotExist() {
        assertNull(this.incidentService.getIncident(ID_NOT_EXIST));
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

