package com.ftn.isa.dto.request;

import com.ftn.isa.domain.Clinic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomCreateRequest {

    @NotNull
    private String name;

    private Clinic clinic;

}
