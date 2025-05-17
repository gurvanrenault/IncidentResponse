package com.incidentresponse.domain.services;

import com.incidentresponse.domain.model.User;
import com.incidentresponse.infrastructure.entity.UserEntity;
import com.incidentresponse.infrastructure.mapper.UserEntityMapper;
import com.incidentresponse.infrastructure.repository.interfaces.IUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserEntityMapper userEntityMapper;
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserEntityMapper userEntityMapper, IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userEntityMapper = userEntityMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isUserByMailExists(String mail){
        Optional<UserEntity> userByMail= this.userRepository.findByMail(mail);
        return userByMail.isPresent();
    }

    public User addUser(User user){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            UserEntity userSaved = userRepository.save(this.userEntityMapper.domainToEntity(user));
            return  this.userEntityMapper.entityToDomain(userSaved);

    }
}
