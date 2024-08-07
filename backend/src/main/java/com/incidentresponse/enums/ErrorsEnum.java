package com.incidentresponse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorsEnum {

    ERROR_INVALID_INCIDENT("IRS-ERR-01", "This incident is invalid");


    public final String code;
    public final String message;

}
