package com.incidentresponse.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private Long id;
    private String description;
    private User user;
    private Incident incident;


}