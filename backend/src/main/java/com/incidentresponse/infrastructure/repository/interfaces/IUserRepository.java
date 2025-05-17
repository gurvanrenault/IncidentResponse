package com.incidentresponse.infrastructure.repository.interfaces;

import com.incidentresponse.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findByMail(String mail);
}
