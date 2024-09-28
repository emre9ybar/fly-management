package com.flyroute.fly.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flights")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "uuid")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Column(name = "flight_duration")
    private double flightDuration;

    @Column(name = "status")
    private String status;

    @Column(name = "price")
    private double price;

    @Column(name = "available_seats")
    private int availableSeats;
}
