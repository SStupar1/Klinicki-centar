package com.ftn.isa.repository;

import com.ftn.isa.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {
    Patient findOneById(Long id);
}
