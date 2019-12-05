package com.ftn.isa.dto.response;

import com.ftn.isa.domain.Clinic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {

    private Long id;

    private String name;

    private Clinic clinic;
}
