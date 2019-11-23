package com.ftn.isa.domain;

import com.ftn.isa.util.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class Authority extends BaseDomain {

    @Enumerated(EnumType.STRING)
    private Role role;
}
