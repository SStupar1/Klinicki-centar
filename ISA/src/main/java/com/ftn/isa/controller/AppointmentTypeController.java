package com.ftn.isa.controller;

import com.ftn.isa.domain.AppointmentType;
import com.ftn.isa.dto.response.AppointmentTypeResponse;
import com.ftn.isa.service.IAppointmentTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/appointmentTypes")
public class AppointmentTypeController {

    private final IAppointmentTypeService _appointmentTypeService;

    public AppointmentTypeController(IAppointmentTypeService appointmentTypeService)
    {
        _appointmentTypeService = appointmentTypeService;
    }

    public ResponseEntity<List<AppointmentTypeResponse>> getAllAppointmentTypes(){

        List<AppointmentTypeResponse> response = _appointmentTypeService.getAllAppointmentTypes();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
