package com.flyroute.fly.service.impl;

import com.flyroute.fly.core.MapperService;
import com.flyroute.fly.dto.AirlineDto;
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
    public Airline create(AirlineDto airlineDto) {

        if (airlineDto.getName().isEmpty() || airlineDto.getCode().isEmpty()) {
            throw new RuntimeException("Airline name and code cannot be empty!");
        }

        Airline airline = this.mapperService.forRequest().map(airlineDto, Airline.class);
        System.out.println("Airline mapped");

        return airlineRepository.save(airline);

    }

    @Override
    @Transactional
    public Airline update(AirlineDto airlineDto) {

        Airline existingAirline = airlineRepository.findById(airlineDto.getId())
                .orElseThrow(() -> new RuntimeException("Airline not found with id: " + airlineDto.getId()));

        mapperService.forRequest().map(airlineDto, existingAirline);

        return airlineRepository.save(existingAirline);

    }

    @Override
    public List<AirlineDto> getAllAirlines() {

        List<Airline> airlineList = airlineRepository.findAll();

        return airlineList.stream()
                .map(airline -> this.mapperService.forResponse().map(airline, AirlineDto.class)).
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
