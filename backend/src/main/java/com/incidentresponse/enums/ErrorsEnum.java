package com.incidentresponse.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorsEnum {

    ERROR_INVALID_INCIDENT("IRS-ERR-01", "This incident is invalid"),
    ERROR_NOT_FOUND_INCIDENT("IRS-ERR-02", "The incident requested doesn't exist"),
    ERROR_INVALID_COMMENT("IRS-ERR-03", "The comment is invalid");

    public final String code;
    public final String message;

}
