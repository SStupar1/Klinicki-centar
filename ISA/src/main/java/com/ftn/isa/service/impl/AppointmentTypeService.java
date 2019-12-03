package com.ftn.isa.service.impl;

import com.ftn.isa.domain.AppointmentType;
import com.ftn.isa.dto.response.AppointmentTypeResponse;
import com.ftn.isa.repository.IAppointmentTypeRepository;
import com.ftn.isa.service.IAppointmentTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppointmentTypeService implements IAppointmentTypeService {

    private IAppointmentTypeRepository _appointmentTypeRepository;

    public AppointmentTypeService(IAppointmentTypeRepository appointmentTypeRepository)
    {
        _appointmentTypeRepository = appointmentTypeRepository;
    }

    @Override
    public List<AppointmentTypeResponse> getAllAppointmentTypes() {
        List<AppointmentType> appointmentTypeList = _appointmentTypeRepository.findAll();
        return appointmentTypeList.stream().map(appointmentType -> mapToResponse(appointmentType)).collect(Collectors.toList());
    }

    private AppointmentTypeResponse mapToResponse(AppointmentType appointmentType) {
        AppointmentTypeResponse response = new AppointmentTypeResponse();
        response.setId(appointmentType.getId());
        response.setName(appointmentType.getName());
        response.setDescription(appointmentType.getDescription());
        return response;
    }
}
