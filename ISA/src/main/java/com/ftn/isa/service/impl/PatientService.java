package com.ftn.isa.service.impl;

import com.ftn.isa.domain.Patient;
import com.ftn.isa.dto.request.PatientCreateRequest;
import com.ftn.isa.dto.request.PatientUpdateRequest;
import com.ftn.isa.dto.response.PatientResponse;
import com.ftn.isa.repository.IPatientRepository;
import com.ftn.isa.service.IPatientService;
import com.ftn.isa.util.Status;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PatientService implements IPatientService {

    private IPatientRepository _patientRepository;

    public PatientService(IPatientRepository patientRepository) {
        _patientRepository = patientRepository;
    }

    @Override
    public PatientResponse getPatientById(Long id) {
        Patient patient = _patientRepository.findOneById(id);
        if(patient == null) {
            return null;
        }
        return mapToResponse(patient);
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        List<Patient> patientList = _patientRepository.findAll();
        return patientList.stream().map(patient -> mapToResponse(patient)).collect(Collectors.toList());
    }

    @Override
    public PatientResponse createPatient(PatientCreateRequest request) {
        Patient patient = mapFromRequest(request);
        Patient savedPatient = _patientRepository.save(patient);
        //kako proveriti da li vec postoji isti
        return mapToResponse(savedPatient);
    }

    @Override
    public PatientResponse updatePatientById(Long id, PatientUpdateRequest request) {
        Patient patient = _patientRepository.findOneById(id);
        if(patient == null) {
            return null;
        }
        Patient patientForUpdate = updatePatient(patient, request);
        Patient savedPatient = _patientRepository.save(patientForUpdate);

        return mapToResponse(savedPatient);
    }

    private Patient updatePatient(Patient patient, PatientUpdateRequest request) {
        if (request.getEmail() != null) {
            patient.setEmail(request.getEmail());
        }
        if (request.getFirstName() != null) {
            patient.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            patient.setLastName(request.getLastName());
        }
        if (request.getCountry() != null) {
            patient.setCountry(request.getCountry());
        }
        if (request.getPhone() != null) {
            patient.setPhone(request.getPhone());
        }
        if (request.getJmbg() != null) {
            patient.setJmbg(request.getJmbg());
        }
        if (request.getCity() != null) {
            patient.setCity(request.getCity());
        }
        if (request.getAddress() != null) {
            patient.setAddress(request.getAddress());
        }
        if(request.getUni() != null) {
            patient.setUni(request.getUni());
        }
        return patient;
    }

    private PatientResponse mapToResponse(Patient patient) {
        PatientResponse response = new PatientResponse();
        response.setId(patient.getId());
        response.setEmail(patient.getEmail());
        response.setFirstName(patient.getFirstName());
        response.setLastName(patient.getLastName());
        response.setAddress(patient.getAddress());
        response.setCity(patient.getCity());
        response.setCountry(patient.getCountry());
        response.setJmbg(patient.getJmbg());
        response.setPhone(patient.getPhone());
        response.setUni(patient.getUni());
        response.setStatus(patient.getStatus());
        return response;
    }

    private Patient mapFromRequest(PatientCreateRequest request) {
        Patient patient = new Patient();
        patient.setEmail(request.getEmail());
        patient.setPassword(request.getPassword());
        patient.setFirstName(request.getFirstName());
        patient.setLastName(request.getLastName());
        patient.setCountry(request.getCountry());
        patient.setJmbg(request.getJmbg());
        patient.setCity(request.getCity());
        patient.setAddress(request.getAddress());
        patient.setPhone(request.getPhone());
        patient.setUni(request.getUni());
        patient.setStatus(Status.PENDING);
        return patient;
    }

}
