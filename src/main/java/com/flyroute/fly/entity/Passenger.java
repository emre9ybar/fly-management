package com.flyroute.fly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "passengers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "uuid")
    private String Uuid;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "passport_number")
    private String passportNumber;

    @Column(name = "localDate_time")
    private LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @OneToMany(mappedBy = "passenger")
    private List<Ticket> tickets;



}
