package com.incidentresponse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorsEnum {

    ERROR_INVALID_INCIDENT("IRS-ERR-01", "This incident is invalid"),
    ERROR_NOT_FOUND_INCIDENT("IRS-ERR-02", "The incident requested doesn't exist");

    public final String code;
    public final String message;

}
