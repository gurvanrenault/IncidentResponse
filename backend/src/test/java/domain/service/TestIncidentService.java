package domain.service;

import com.incidentresponse.application.application.IncidentApplication;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.domain.model.User;
import com.incidentresponse.domain.services.IncidentService;
import com.incidentresponse.enums.PriorityStatusEnum;
import com.incidentresponse.enums.StatusIncidentEnum;
import com.incidentresponse.infrastructure.entity.IncidentEntity;
import com.incidentresponse.infrastructure.entity.UserEntity;
import com.incidentresponse.infrastructure.mapper.IncidentEntityMapper;
import com.incidentresponse.infrastructure.repository.interfaces.IIncidentRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = IncidentApplication.class)
public class TestIncidentService {

    private final Long ID_EXIST = 42L;
    private final Long ID_NOT_EXIST = 4L;

    private final IncidentEntity[] ARRAY_INCIDENT_ENTITY = new IncidentEntity[]
            {this.generateIncidentEntity()};
    private final Incident[] ARRAY_INCIDENT = new Incident[]
            {this.generateIncident()};

    private final int SIZE_PAGE = 10;
    private final int PAGE_NUMBER_NOT_EMPTY = 0;
    private final int PAGE_NUMBER_EMPTY = 1;

    private final Pageable PAGE_REQUEST_NOT_EMPTY = PageRequest.of(PAGE_NUMBER_NOT_EMPTY, SIZE_PAGE);
    private final Pageable PAGE_REQUEST_EMPTY = PageRequest.of(PAGE_NUMBER_EMPTY, SIZE_PAGE);

    private final List<IncidentEntity> EMPTY_LIST_ENTITY = new ArrayList<>();
    private final Page<IncidentEntity> EMPTY_PAGE = new PageImpl<>(EMPTY_LIST_ENTITY);
    private final List<IncidentEntity> LIST_ENTITY = Arrays.stream(ARRAY_INCIDENT_ENTITY).toList();
    private final Page<IncidentEntity> NOT_EMPTY_PAGE = new PageImpl<>(LIST_ENTITY);


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
        when(incidentRepository.findAll(PAGE_REQUEST_EMPTY)).thenReturn(EMPTY_PAGE);
        when(incidentRepository.findAll(PAGE_REQUEST_NOT_EMPTY)).thenReturn(NOT_EMPTY_PAGE);
        when(incidentEntityMapper.entityToDomain(any())).thenReturn(new Incident());
        when(incidentEntityMapper.listEntityToDomain(EMPTY_LIST_ENTITY)).thenReturn(new ArrayList<>());
        when(incidentEntityMapper.listEntityToDomain(LIST_ENTITY)).thenReturn(Arrays.stream(ARRAY_INCIDENT).toList());
    }

    @Test
    public void testAddIncident() {
        Incident incident = generateIncident();
        assertNotNull(this.incidentService.addIncident(incident));
    }

    @Test
    public void testGetIncidentExist() {
        assertNotNull(this.incidentService.getIncident(ID_EXIST));
    }

    @Test
    public void testGetIncidentNotExist() {
        assertNull(this.incidentService.getIncident(ID_NOT_EXIST));
    }

    @Test
    public void testDeleteIncidentExist() {
        Assertions.assertTrue(this.incidentService.deleteIncident(ID_EXIST));
    }

    @Test
    public void testDeleteIncidentNotExist() {
        Assertions.assertFalse(this.incidentService.deleteIncident(ID_NOT_EXIST));
    }

    @Test
    public void testEmptyPageGetIncidents() {
        List<Incident> incidentList = this.incidentService.getAllIncidents(PAGE_NUMBER_EMPTY);
        assertEquals(0, incidentList.size());
    }

    @Test
    public void testNotEmptyPageGetIncidents() {
        List<Incident> incidentList = this.incidentService.getAllIncidents(PAGE_NUMBER_NOT_EMPTY);
        assertEquals(1, incidentList.size());
    }

    @Test
    public void testErrorPageGetIncidents() {
        final int PAGE_NUMBER_ERROR = -1;
        List<Incident> incidentList = this.incidentService.getAllIncidents(PAGE_NUMBER_ERROR);
        assertEquals(0, incidentList.size());
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

