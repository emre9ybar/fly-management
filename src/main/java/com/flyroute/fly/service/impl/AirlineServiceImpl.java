package com.flyroute.fly.service.impl;

import com.flyroute.fly.core.MapperService;
import com.flyroute.fly.dto.request.GetAirlineListResponse;
import com.flyroute.fly.dto.request.UpdateAirlineRequest;
import com.flyroute.fly.entity.Airline;
import com.flyroute.fly.repository.AirlineRepository;
import com.flyroute.fly.service.AirlineService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AirlineServiceImpl implements AirlineService {

    private final MapperService mapperService;
    private final AirlineRepository airlineRepository;

    public AirlineServiceImpl(MapperService mapperService, AirlineRepository airlineRepository) {
        this.mapperService = mapperService;
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline create(GetAirlineListResponse airlineDto) {

        if (airlineDto.getName().isEmpty() || airlineDto.getCode().isEmpty()) {
            throw new RuntimeException("Airline name and code cannot be empty!");
        }

        Airline airline = this.mapperService.forRequest().map(airlineDto, Airline.class);
        System.out.println("Airline mapped");

        return airlineRepository.save(airline);

    }

    @Override
    @Transactional
    public Airline update(UpdateAirlineRequest UpdateAirlineRequest) {

        Airline existingAirline = airlineRepository.findById(UpdateAirlineRequest.getId())
                .orElseThrow(() -> new RuntimeException("Airline not found with id: " + UpdateAirlineRequest.getId()));

        mapperService.forRequest().map(UpdateAirlineRequest, existingAirline);

        return airlineRepository.save(existingAirline);

    }

    @Override
    public List<GetAirlineListResponse> getAllAirlines() {

        List<Airline> airlineList = airlineRepository.findAll();

        return airlineList.stream()
                .map(airline -> this.mapperService.forResponse().map(airline, GetAirlineListResponse.class)).
                collect(Collectors.toList());

    }

    @Override
    public Optional<Airline> getAirlineById(Long id) {
        return airlineRepository.findById(id);
    }

    @Override
    public String delete(Long id) {

        Optional<Airline> optionalAirline = airlineRepository.findById(id);

        if (optionalAirline.isEmpty()) {
            throw new RuntimeException("Airline not found with id: "+id);
        }

        airlineRepository.deleteById(id);

        return "Airline has been deleted with id: "+id;

    }

}
