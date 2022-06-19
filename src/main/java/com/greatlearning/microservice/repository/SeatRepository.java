package com.greatlearning.microservice.repository;

import com.greatlearning.microservice.entity.Seat;
import com.greatlearning.microservice.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
