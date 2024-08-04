package com.incidentresponse.application.dto;

import com.incidentresponse.enums.PriorityStatusEnum;
import com.incidentresponse.enums.StatusIncidentEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class IncidentDTO {


    private Long id;
    private String title;
    private UserDTO user_assignated;
    private String description;
    private PriorityStatusEnum priority;
    private StatusIncidentEnum status;
    private ArrayList<CommentaryDTO> commentaries;
    private Date date;
}
