package com.ftn.isa.repository;

import com.ftn.isa.domain.AppointmentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentTypeRepository extends JpaRepository<AppointmentType, Long> {
    AppointmentType findOneById(Long id);
}
