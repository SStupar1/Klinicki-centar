package com.ftn.isa.service;

import com.ftn.isa.domain.AppointmentType;
import com.ftn.isa.dto.response.AppointmentTypeResponse;

import java.util.List;

public interface IAppointmentTypeService {

    List<AppointmentTypeResponse> getAllAppointmentTypes();
}
