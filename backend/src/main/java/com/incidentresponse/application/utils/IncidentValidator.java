package com.incidentresponse.application.utils;

import com.incidentresponse.application.dto.IncidentDTO;
import io.micrometer.common.util.StringUtils;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IncidentValidator implements Validator<IncidentDTO> {

    @Override
    public boolean isValid(IncidentDTO obj) {

        boolean isValid = (obj.getStatus() != null) && (obj.getPriority() != null);
        if (StringUtils.isEmpty(obj.getTitle())) {
            isValid = false;
        }
        if (StringUtils.isEmpty(obj.getDescription())) {
            isValid = false;
        }

        return isValid;
    }
}
