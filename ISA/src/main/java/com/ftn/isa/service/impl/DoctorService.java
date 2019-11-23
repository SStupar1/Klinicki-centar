package com.ftn.isa.service.impl;

import com.ftn.isa.domain.Doctor;
import com.ftn.isa.dto.request.DoctorCreateRequest;
import com.ftn.isa.dto.response.DoctorResponse;
import com.ftn.isa.repository.IDoctorRepository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private IDoctorRepository _doctorRepository;

    public DoctorService(IDoctorRepository doctorRepository)
    {
        _doctorRepository = doctorRepository;
    }

/*
    @Override
    public DoctorResponse createMedial(DoctorCreateRequest request) {
        Doctor doctor = new Doctor();
        doctor.setName(request.getName());
        doctor.setDescription(request.getDescription());

        Doctor savedMedicine = _doctorRepository.save(doctor);

        return mapToResponse(savedDoctor);
    }

 */

}
