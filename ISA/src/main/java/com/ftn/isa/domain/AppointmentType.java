package com.ftn.isa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class AppointmentType extends BaseDomain{

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "appointmentType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Set<Appointment> appointments = new HashSet<Appointment>();
}
