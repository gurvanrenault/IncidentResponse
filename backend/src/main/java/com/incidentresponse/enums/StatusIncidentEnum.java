package com.incidentresponse.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.Optional;

public enum StatusIncidentEnum {

    TO_DO("TO DO"),
    IN_PROGRESS("IN PROGRESS"),
    DONE("DONE");

    public final String label;

    StatusIncidentEnum(String label) {
        this.label = label;
    }

    @JsonCreator
    public static StatusIncidentEnum getFromValue(String value) {

        Optional<StatusIncidentEnum> optionalStatusIncidentEnum =
                Arrays.stream(StatusIncidentEnum.values())
                        .filter(bl -> bl.label.equalsIgnoreCase(value))
                        .findFirst();
        return optionalStatusIncidentEnum.orElse(null);


    }
}
