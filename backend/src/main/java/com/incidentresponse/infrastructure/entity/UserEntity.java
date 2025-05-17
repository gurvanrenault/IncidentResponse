package com.incidentresponse.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "name")
    private String name;

    @Column(name = "company")
    private String company;

}