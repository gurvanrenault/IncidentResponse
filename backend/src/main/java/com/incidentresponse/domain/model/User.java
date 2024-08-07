package com.incidentresponse.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String mail;
    private String lastname;
    private String name;
    private String company;

}