package com.ftn.isa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Appointment{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private AppointmentType appointmentType;

    @Column(name = "start_time", nullable = false)
    private String startTime;

    @Column(name = "end_time", nullable = false)
    private String endTime;

    @Column(name = "cost", nullable = false)
    private int cost;

    @Column(name = "status", nullable = false)
    private String status;

    private int discount;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Room room;


}
