package com.ftn.isa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Patient extends User{

    @Column(name = "unique_number_insurance", nullable = false, unique = true)
    private String uni;

    @ManyToMany(mappedBy = "patients")
    Set<Clinic> clinics = new HashSet<Clinic>();

}
