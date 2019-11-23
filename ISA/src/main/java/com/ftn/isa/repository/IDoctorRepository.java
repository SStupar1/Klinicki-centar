package com.ftn.isa.repository;

import com.ftn.isa.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDoctorRepository extends JpaRepository<Doctor, Long> {
    Doctor findOneById(Long id);
}
