package com.ftn.isa.controller;

import com.ftn.isa.dto.request.AppointmentTypeCreateRequest;
import com.ftn.isa.dto.request.AppointmentTypeUpdateRequest;
import com.ftn.isa.dto.response.AppointmentTypeResponse;
import com.ftn.isa.service.IAppointmentTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/api/appointmentTypes")
public class AppointmentTypeController {

    private final IAppointmentTypeService _appointmentTypeService;

    public AppointmentTypeController(IAppointmentTypeService appointmentTypeService)
    {
        _appointmentTypeService = appointmentTypeService;
    }

    @GetMapping()
    public ResponseEntity<List<AppointmentTypeResponse>> getAllAppointmentTypes(){

        List<AppointmentTypeResponse> response = _appointmentTypeService.getAllAppointmentTypes();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentTypeResponse> getAppointmentTypeById(@PathVariable Long id) {
        AppointmentTypeResponse response = _appointmentTypeService.getOneAppointmentType(id);
        if(response == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<AppointmentTypeResponse> createAppointmentType(@RequestBody @Valid AppointmentTypeCreateRequest request){
        AppointmentTypeResponse response = _appointmentTypeService.createAppointmentType(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppointmentTypeResponse> updateAppointmentType(@RequestBody AppointmentTypeUpdateRequest request, @PathVariable Long id){
        AppointmentTypeResponse response = _appointmentTypeService.updateAppointmentTypeById(request, id);
        if(response == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
