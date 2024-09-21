package com.flyroute.fly.service;

import com.flyroute.fly.dto.AirlineDto;
import com.flyroute.fly.entity.Airline;

public interface AirlineService {

    Airline create(AirlineDto airlineDto);

    Airline update(AirlineDto airlineDto);

}
