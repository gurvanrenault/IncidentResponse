package com.incidentresponse.application.utils;

import com.incidentresponse.application.dto.CommentDTO;
import io.micrometer.common.util.StringUtils;

public class CommentValidator implements Validator<CommentDTO> {
    @Override
    public boolean isValid(CommentDTO obj) {

        return !StringUtils.isEmpty(obj.getDescription()) && (obj.getUser() != null) && (obj.getIncident() != null);
    }
}
