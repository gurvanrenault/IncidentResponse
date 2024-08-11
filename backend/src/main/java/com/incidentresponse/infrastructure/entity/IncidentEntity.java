package com.incidentresponse.infrastructure.entity;

import com.incidentresponse.enums.PriorityStatusEnum;
import com.incidentresponse.enums.StatusIncidentEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "incident")
public class IncidentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne
    @JoinColumn(name = "user_assignated")
    private UserEntity userAssignated;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private PriorityStatusEnum priority;

    @Column(name = "status")
    private StatusIncidentEnum status;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}
