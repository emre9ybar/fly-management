package com.flyroute.fly.service;

import com.flyroute.fly.dto.AirlineDto;
import com.flyroute.fly.entity.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineService {

    Airline create(AirlineDto airlineDto);

    Airline update(AirlineDto airlineDto);

    List<AirlineDto> getAllAirlines();

    Optional<Airline> getAirlineById(Long id);

    String delete(Long id);

}
