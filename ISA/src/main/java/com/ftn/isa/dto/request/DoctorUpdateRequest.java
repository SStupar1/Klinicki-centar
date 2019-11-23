package com.ftn.isa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorUpdateRequest {
    @NotNull
    @Email
    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String country;

    private String phone;

    @NotNull
    private String jmbg;
}
