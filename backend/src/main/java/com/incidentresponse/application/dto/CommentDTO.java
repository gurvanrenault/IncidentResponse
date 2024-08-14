package com.incidentresponse.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

    private Long id;
    private String description;
    private UserDTO user;
    private IncidentDTO incident;




}