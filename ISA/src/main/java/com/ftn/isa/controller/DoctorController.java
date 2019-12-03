package com.ftn.isa.controller;

import com.ftn.isa.dto.request.DoctorCreateRequest;
import com.ftn.isa.dto.request.DoctorUpdateRequest;
import com.ftn.isa.dto.response.DoctorResponse;
import com.ftn.isa.service.IDoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final IDoctorService _doctorService;

    public DoctorController(IDoctorService doctorService)
    {
        _doctorService = doctorService;
    }

    @GetMapping()
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        List<DoctorResponse> response = _doctorService.getAllDoctors();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorResponse> getDoctorById(@PathVariable Long id) {
        DoctorResponse response = _doctorService.getDoctorById(id);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody @Valid DoctorCreateRequest request) {
        DoctorResponse response = _doctorService.createDoctor(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorResponse> updateDoctor(@PathVariable Long id, @RequestBody @Valid
            DoctorUpdateRequest request) {
        DoctorResponse response = _doctorService.updateDoctorById(id, request);
        if (response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
