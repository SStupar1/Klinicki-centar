package com.ftn.isa.service;

import com.ftn.isa.dto.request.DoctorCreateRequest;
import com.ftn.isa.dto.request.DoctorUpdateRequest;
import com.ftn.isa.dto.response.DoctorResponse;

import java.util.List;

public interface IDoctorService {

    DoctorResponse getDoctorById(Long id);
    List<DoctorResponse> getAllDoctors();
    DoctorResponse createDoctor(DoctorCreateRequest request);
    DoctorResponse updateDoctorById(Long id, DoctorUpdateRequest request);
}
