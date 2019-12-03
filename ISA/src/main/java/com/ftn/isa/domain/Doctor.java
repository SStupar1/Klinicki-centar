package com.ftn.isa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Doctor extends User{

    @Column(name = "work_time_start")
    private String start;

    @Column(name="work_time_end")
    private String end;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Clinic clinic;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    Set<Appointment> appointments = new HashSet<>();

}
