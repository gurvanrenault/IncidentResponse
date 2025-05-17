package com.incidentresponse.application.controller;

import com.incidentresponse.application.dto.UserDTO;
import com.incidentresponse.application.mapper.UserDTOMapper;
import com.incidentresponse.application.utils.UserValidator;
import com.incidentresponse.domain.model.User;
import com.incidentresponse.domain.services.UserService;
import com.incidentresponse.enums.ErrorsEnum;
import com.incidentresponse.errors.IncidentResponseError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthentificationController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final UserDTOMapper userDTOMapper;

    public AuthentificationController(AuthenticationManager authenticationManager, UserService userService, UserDTOMapper userDTOMapper) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());
        Authentication authenticationResponse =
                this.authenticationManager.authenticate(authenticationRequest);
        // ...
        return null;
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDto) {
            UserValidator userValidator = new UserValidator();
            if (! userValidator.isValid())
            if (!this.userService.isUserByMailExists(userDto.getMail())) {
                User user = this.userService.addUser(this.userDTOMapper.applicationToDomain(userDto));
                return ResponseEntity.ok(this.userDTOMapper.domainToApplication(user));
            }
            return new ResponseEntity<>(new IncidentResponseError(ErrorsEnum.ERROR_USER_EXISTS.getCode(), ErrorsEnum.ERROR_USER_EXISTS.getMessage()), HttpStatus.NOT_FOUND);
    }

    public record LoginRequest(String username, String password) {
    }


}
