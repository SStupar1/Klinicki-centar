package com.ftn.isa.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientUpdateRequest {

    @Email
    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String country;

    private String phone;

    private String jmbg;

    private String uni;
}
