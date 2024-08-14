package com.incidentresponse.domain.model;

import com.incidentresponse.enums.PriorityStatusEnum;
import com.incidentresponse.enums.StatusIncidentEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Incident {


    private Long id;
    private String title;
    private User userAssignated;
    private String description;
    private PriorityStatusEnum priority;
    private StatusIncidentEnum status;
    private Date date;
}
