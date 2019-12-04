package com.ftn.isa.service;

import com.ftn.isa.domain.Appointment;
import com.ftn.isa.domain.AppointmentType;
import com.ftn.isa.dto.request.AppointmentTypeCreateRequest;
import com.ftn.isa.dto.request.AppointmentTypeUpdateRequest;
import com.ftn.isa.dto.response.AppointmentTypeResponse;

import java.util.List;

public interface IAppointmentTypeService {

    List<AppointmentTypeResponse> getAllAppointmentTypes();
    AppointmentTypeResponse getOneAppointmentType(Long id);
    AppointmentTypeResponse createAppointmentType(AppointmentTypeCreateRequest request);
    AppointmentTypeResponse updateAppointmentTypeById(AppointmentTypeUpdateRequest request, Long id);
}
