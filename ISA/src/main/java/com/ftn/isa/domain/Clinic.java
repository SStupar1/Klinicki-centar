package com.ftn.isa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Clinic{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "clinic_patient",
            joinColumns = @JoinColumn(name = "clinic_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id",referencedColumnName = "id")
    )
    private Set<Patient> patients = new HashSet<Patient>();

    @OneToMany(mappedBy = "clinic",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Set<Doctor> doctors = new HashSet<Doctor>();

    @OneToMany(mappedBy = "clinic",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    Set<Room> rooms = new HashSet<Room>();

}
