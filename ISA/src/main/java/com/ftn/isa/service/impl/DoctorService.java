package com.ftn.isa.service.impl;

import com.ftn.isa.domain.Doctor;
import com.ftn.isa.dto.request.DoctorCreateRequest;
import com.ftn.isa.dto.request.DoctorUpdateRequest;
import com.ftn.isa.dto.response.DoctorResponse;
import com.ftn.isa.repository.IDoctorRepository;
import com.ftn.isa.service.IDoctorService;
import com.ftn.isa.util.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService implements IDoctorService {
    private IDoctorRepository _doctorRepository;

    public DoctorService(IDoctorRepository doctorRepository)
    {
        _doctorRepository = doctorRepository;
    }

    @Override
    public DoctorResponse getDoctorById(Long id) {
        Doctor doctor = _doctorRepository.findOneById(id);

        // TODO: Throw exception in next iteration
        if (doctor == null) {
            return null;
        }

        return mapToResponse(doctor);
    }

    @Override
    public List<DoctorResponse> getAllDoctors() {
        List<Doctor> doctorList = _doctorRepository.findAll();

        return doctorList.stream().map(doctor -> mapToResponse(doctor)).collect(Collectors.toList());
    }

    @Override
    public DoctorResponse createDoctor(DoctorCreateRequest request) {

        Doctor doctor = mapFromRequest(request);
        Doctor savedDoctor = _doctorRepository.save(doctor);

        //kako da proverim ako vec postoji isti
        //hoce li to za mene uraditi unique???

        return mapToResponse(savedDoctor);
    }

    @Override
    public DoctorResponse updateDoctorById(Long id, DoctorUpdateRequest request) {
        Doctor doctor = _doctorRepository.findOneById(id);

        // TODO: Throw exception in next iteration
        if (doctor == null) {
            return null;
        }

        Doctor doctorForUpdate = updateDoctor(doctor, request);

        Doctor savedDoctor = _doctorRepository.save(doctorForUpdate);

        return mapToResponse(savedDoctor);
    }

    private Doctor updateDoctor(Doctor doctor, DoctorUpdateRequest request) {

        if (request.getEmail() != null) {
            doctor.setEmail(request.getEmail());
        }

        if (request.getFirstName() != null) {
            doctor.setFirstName(request.getFirstName());
        }

        if (request.getLastName() != null) {
            doctor.setLastName(request.getLastName());
        }
        if (request.getCountry() != null) {
            doctor.setCountry(request.getCountry());
        }
        if (request.getPhone() != null) {
            doctor.setPhone(request.getPhone());
        }
        if (request.getJmbg() != null) {
            doctor.setJmbg(request.getJmbg());
        }
        if (request.getCity() != null) {
            doctor.setCity(request.getCity());
        }
        if (request.getAddress() != null) {
            doctor.setAddress(request.getAddress());
        }

        return doctor;
    }


    private DoctorResponse mapToResponse(Doctor doctor) {
        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId());
        response.setEmail(doctor.getEmail());
        response.setFirstName(doctor.getFirstName());
        response.setLastName(doctor.getLastName());
        response.setAddress(doctor.getAddress());
        response.setCity(doctor.getCity());
        response.setCountry(doctor.getCountry());
        response.setJmbg(doctor.getJmbg());
        response.setPhone(doctor.getPhone());
        response.setStatus(doctor.getStatus());
        return response;
    }

    private Doctor mapFromRequest(DoctorCreateRequest request){
        Doctor doctor = new Doctor();
        doctor.setEmail(request.getEmail());
        //moracemo da hesiramo password
        doctor.setPassword(request.getPassword());
        doctor.setFirstName(request.getFirstName());
        doctor.setLastName(request.getLastName());
        doctor.setCountry(request.getCountry());
        doctor.setJmbg(request.getJmbg());
        doctor.setCity(request.getCity());
        doctor.setAddress(request.getAddress());
        doctor.setPhone(request.getPhone());
        doctor.setStatus(Status.PENDING);
        //setovati start i end i autoriti ostalo

        return doctor;
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
