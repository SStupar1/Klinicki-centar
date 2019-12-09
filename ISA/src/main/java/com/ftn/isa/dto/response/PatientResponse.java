package com.ftn.isa.dto.response;

import com.ftn.isa.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {

    private Long id;

    private String email;

    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String country;

    private String phone;

    private String jmbg;

    private String uni;

    private Status status;
}
