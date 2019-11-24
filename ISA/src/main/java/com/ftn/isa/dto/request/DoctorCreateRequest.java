package com.ftn.isa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorCreateRequest {

    @NotNull
    private String email;
    @NotNull
    private String password;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String country;

    private String phone;
    @NotNull
    private String jmbg; //jedinstveni broj osiguranika

}
