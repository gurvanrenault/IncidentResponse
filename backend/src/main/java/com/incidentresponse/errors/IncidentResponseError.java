package com.incidentresponse.errors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IncidentResponseError {

    private String code;
    private String message;

    public IncidentResponseError(String code, String message) {
        this.message = message;
        this.code = code;
    }
}
