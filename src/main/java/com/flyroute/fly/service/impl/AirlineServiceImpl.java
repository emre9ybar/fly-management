package com.flyroute.fly.service.impl;

import com.flyroute.fly.core.MapperService;
import com.flyroute.fly.dto.AirlineDto;
import com.flyroute.fly.entity.Airline;
import com.flyroute.fly.repository.AirlineRepository;
import com.flyroute.fly.service.AirlineService;
import org.springframework.stereotype.Service;

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
    public Airline update(AirlineDto airlineDto) {

        Optional<Airline> optionalAirline = airlineRepository.findById(airlineDto.getId());

        if (!optionalAirline.isPresent()) {
            throw new RuntimeException("Airline not found with id: "+airlineDto.getId());
        }

        Airline airline = optionalAirline.get(); // current record

        airline.setCode(airlineDto.getCode());
        airline.setCountry(airlineDto.getCountry());
        airline.setName(airlineDto.getName());
        airline.setWebsite(airlineDto.getWebsite());

        return airlineRepository.save(airline);

    }

}
