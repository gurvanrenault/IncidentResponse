package com.incidentresponse.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class CommentDTO {

    private Long id;
    private String description;
    private UserDTO user;
    private IncidentDTO incident;




}