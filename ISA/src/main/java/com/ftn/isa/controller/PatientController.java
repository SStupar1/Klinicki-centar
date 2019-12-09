package com.ftn.isa.controller;

import com.ftn.isa.dto.request.PatientCreateRequest;
import com.ftn.isa.dto.request.PatientUpdateRequest;
import com.ftn.isa.dto.response.PatientResponse;
import com.ftn.isa.service.IPatientService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final IPatientService _patientService;

    public PatientController(IPatientService patientService) {
        _patientService = patientService;
    }

    @GetMapping()
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        List<PatientResponse> response = _patientService.getAllPatients();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable Long id) {
        PatientResponse response = _patientService.getPatientById(id);
        if(response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<PatientResponse> createPatient(@RequestBody @Valid PatientCreateRequest request) {
        PatientResponse response = _patientService.createPatient(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long id, @RequestBody @Valid PatientUpdateRequest request) {
        PatientResponse response = _patientService.updatePatientById(id, request);
        if(response == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
