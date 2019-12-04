package com.ftn.isa.service.impl;

import com.ftn.isa.domain.Appointment;
import com.ftn.isa.domain.AppointmentType;
import com.ftn.isa.dto.request.AppointmentTypeCreateRequest;
import com.ftn.isa.dto.request.AppointmentTypeUpdateRequest;
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

    @Override
    public AppointmentTypeResponse getOneAppointmentType(Long id) {
        AppointmentType appointmentType = _appointmentTypeRepository.findOneById(id);
        if(appointmentType == null)
            return null;
        return mapToResponse(appointmentType);
    }

    @Override
    public AppointmentTypeResponse createAppointmentType(AppointmentTypeCreateRequest request) {
        AppointmentType appointmentType = mapFromRequest(request);
        AppointmentType savedAppointmentType = _appointmentTypeRepository.save(appointmentType);
        return mapToResponse(savedAppointmentType);
    }

    @Override
    public AppointmentTypeResponse updateAppointmentTypeById(AppointmentTypeUpdateRequest request, Long id) {
        AppointmentType appointmentType = _appointmentTypeRepository.findOneById(id);
        if(appointmentType == null)
            return null;

        AppointmentType updatedAppointmentType = updateAppointmentType(appointmentType, request);
        AppointmentType savedAppointmentType = _appointmentTypeRepository.save(updatedAppointmentType);
        return mapToResponse(savedAppointmentType);
    }

    private AppointmentType updateAppointmentType(AppointmentType appointmentType, AppointmentTypeUpdateRequest request) {
        if(request.getName() != null)
            appointmentType.setName(request.getName());

        if(request.getDescription() != null)
            appointmentType.setDescription(request.getDescription());

        return appointmentType;
    }


    private AppointmentType mapFromRequest(AppointmentTypeCreateRequest request) {
        AppointmentType appointmentType = new AppointmentType();
        appointmentType.setName(request.getName());
        appointmentType.setDescription(request.getDescription());
        return appointmentType;
    }


    private AppointmentTypeResponse mapToResponse(AppointmentType appointmentType) {
        AppointmentTypeResponse response = new AppointmentTypeResponse();
        response.setId(appointmentType.getId());
        response.setName(appointmentType.getName());
        response.setDescription(appointmentType.getDescription());
        return response;
    }
}
