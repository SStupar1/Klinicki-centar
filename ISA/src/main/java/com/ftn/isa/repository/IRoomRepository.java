package com.ftn.isa.repository;

import com.ftn.isa.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Long>{
    Room findOneById(Long id);
}
