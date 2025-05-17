package com.incidentresponse.application.utils;

import com.incidentresponse.application.dto.UserDTO;
import org.apache.commons.validator.routines.EmailValidator;

public class UserValidator implements Validator<UserDTO> {


    @Override
    public boolean isValid(UserDTO obj) {

        boolean isValid = (obj.getPassword() != null) &&  (obj.getMail() != null)
        EmailValidator mailVal = EmailValidator.getInstance();
        if (!mailVal.isValid(obj.getMail())){
            isValid=false;
        }


        return isValid;
    }
}
