package com.ftn.isa.controller;

import com.ftn.isa.dto.request.DoctorCreateRequest;
import com.ftn.isa.dto.response.DoctorResponse;
import com.ftn.isa.service.IDoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    /*
    private final IDoctorService _doctorService;

    public DoctorController(IDoctorService doctorService)
    {
        _doctorService = doctorService;
    }

    @PostMapping()
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody @Valid DoctorCreateRequest request) {
        DoctorResponse response = _doctorService.createDoctor(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    */
}
