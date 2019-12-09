package com.ftn.isa.service;

import com.ftn.isa.dto.request.PatientCreateRequest;
import com.ftn.isa.dto.request.PatientUpdateRequest;
import com.ftn.isa.dto.response.PatientResponse;

import java.util.List;

public interface IPatientService {

    PatientResponse getPatientById(Long id);
    List<PatientResponse> getAllPatients();
    PatientResponse createPatient(PatientCreateRequest request);
    PatientResponse updatePatientById(Long id, PatientUpdateRequest request);
}
