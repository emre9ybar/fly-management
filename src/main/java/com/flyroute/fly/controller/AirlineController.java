package com.flyroute.fly.controller;

import com.flyroute.fly.dto.AirlineDto;
import com.flyroute.fly.service.AirlineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airline")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @PostMapping
    public ResponseEntity<AirlineDto> create(@RequestBody AirlineDto airlineDto) {

        try {
            airlineService.create(airlineDto);
            System.out.println("Airline created.");

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println("Error.");

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

}
