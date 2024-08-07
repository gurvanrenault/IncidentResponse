package com.incidentresponse.application.controller;

import com.incidentresponse.application.dto.IncidentDTO;
import com.incidentresponse.application.mapper.IncidentDTOMapper;
import com.incidentresponse.application.utils.IncidentValidator;
import com.incidentresponse.domain.interfaces.IIncidentService;
import com.incidentresponse.domain.model.Incident;
import com.incidentresponse.enums.ErrorsEnum;
import com.incidentresponse.errors.IncidentResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IncidentController {

    private final IIncidentService incidentService;
    private final IncidentDTOMapper incidentDTOMapper;

    public IncidentController(IIncidentService incidentService, IncidentDTOMapper incidentDTOMapper) {
        this.incidentService = incidentService;
        this.incidentDTOMapper = incidentDTOMapper;
    }

    @PostMapping(path = "/incidents")
    public ResponseEntity<?> addIncident(@RequestBody IncidentDTO incidentDTO) {
        IncidentValidator incidentValidator = new IncidentValidator();
        if (incidentValidator.isValid(incidentDTO)) {
            Incident incidentCreated = this.incidentService.addIncident(this.incidentDTOMapper.applicationToDomain(incidentDTO));
            return ResponseEntity.ok(this.incidentDTOMapper.domainToApplication(incidentCreated));
        } else {
            return new ResponseEntity<>(new IncidentResponseError(ErrorsEnum.ERROR_INVALID_INCIDENT.getCode(), ErrorsEnum.ERROR_INVALID_INCIDENT.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


}
