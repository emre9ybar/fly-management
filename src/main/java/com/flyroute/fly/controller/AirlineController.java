package com.flyroute.fly.controller;

import com.flyroute.fly.dto.AirlineDto;
import com.flyroute.fly.entity.Airline;
import com.flyroute.fly.service.AirlineService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
            System.out.println("Error."+e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

    @PutMapping
    public ResponseEntity<AirlineDto> update(@RequestBody AirlineDto airlineDto) {

        try {
            airlineService.update(airlineDto);
            System.out.println("Airline updated.");

            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            System.out.println("Error."+e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<AirlineDto>> getAllAirlines() {

        try {
            List<AirlineDto> airlineDtos = airlineService.getAllAirlines();
            System.out.println("All airlines have been retrieved.");

            return ResponseEntity.ok(airlineDtos);
        } catch (Exception e) {
            System.out.println("Error. "+e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/find")
    public ResponseEntity<Optional<Airline>> getAirlineById(@RequestParam long id) {

        try {
            Optional<Airline> airline = airlineService.getAirlineById(id);
            System.out.println("Airline has been found with id: "+id);

            return ResponseEntity.ok(airline);
        } catch (Exception e) {
            System.out.println("Error. "+e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam long id) {

        try {
            String result = airlineService.delete(id);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            System.out.println("Error. "+e);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}
