package com.ftn.isa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentTypeResponse {

    private Long id;

    private String name;

    private String description;

    //dodati i liste????
}
