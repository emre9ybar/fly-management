package com.flyroute.fly.controller;

import com.flyroute.fly.dto.request.airlinerequest.UpdateAirlineRequest;
import com.flyroute.fly.dto.response.airlineresponse.GetAirlineListResponse;
import com.flyroute.fly.entity.Airline;
import com.flyroute.fly.service.AirlineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {

    private final AirlineService airlineService;

    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    // Uçak şirketi oluşturma
    @PostMapping
    public ResponseEntity<Airline> createAirline(@RequestBody GetAirlineListResponse airlineDto) {
        Airline createdAirline = airlineService.create(airlineDto);
        return ResponseEntity.ok(createdAirline);
    }

    // Uçak şirketi güncelleme
    @PutMapping("/{id}")
    public ResponseEntity<Airline> updateAirline(@PathVariable Long id, @RequestBody UpdateAirlineRequest updateAirlineRequest) {
        updateAirlineRequest.setId(id);  // UpdateAirlineRequest içinde id'yi güncelliyoruz
        Airline updatedAirline = airlineService.update(updateAirlineRequest);
        return ResponseEntity.ok(updatedAirline);
    }

    // Tüm uçak şirketlerini listeleme
    @GetMapping
    public ResponseEntity<List<GetAirlineListResponse>> getAllAirlines() {
        List<GetAirlineListResponse> airlines = airlineService.getAllAirlines();
        return ResponseEntity.ok(airlines);
    }

    // Belirli bir id'ye göre uçak şirketi bulma
    @GetMapping("/{id}")
    public ResponseEntity<Airline> getAirlineById(@PathVariable Long id) {
        Optional<Airline> airline = airlineService.getAirlineById(id);
        return airline.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Uçak şirketi silme
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAirline(@PathVariable Long id) {
        String response = airlineService.delete(id);
        return ResponseEntity.ok(response);
    }
}
