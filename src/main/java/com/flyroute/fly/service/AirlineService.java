package com.flyroute.fly.service;

import com.flyroute.fly.dto.request.airlinerequest.CreateAirlineRequest;
import com.flyroute.fly.dto.request.airlinerequest.UpdateAirlineRequest;
import com.flyroute.fly.dto.response.airlineresponse.GetAirlineListResponse;
import com.flyroute.fly.entity.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineService {

    Airline create(CreateAirlineRequest createAirlineRequest);

    Airline update(UpdateAirlineRequest UpdateAirlineRequest);

    List<GetAirlineListResponse> getAllAirlines();

    Optional<Airline> getAirlineById(Long id);

    String delete(Long id);

}
