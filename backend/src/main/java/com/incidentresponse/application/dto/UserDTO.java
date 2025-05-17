package com.incidentresponse.application.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
public class UserDTO {
    private Long id;
    private String mail;
    private String password;
    private String lastname;
    private String name;
    private String company;

}