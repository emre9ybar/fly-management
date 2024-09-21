package com.flyroute.fly.repository;

import com.flyroute.fly.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {

}
