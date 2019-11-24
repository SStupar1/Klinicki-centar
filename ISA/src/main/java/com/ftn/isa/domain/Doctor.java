package com.ftn.isa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Doctor extends User{

    @Column(name = "work_time_start")
    private String start;

    @Column(name="work_time_end")
    private String end;


    //@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    //private Clinic clinic;

    //dodati appointment

}
