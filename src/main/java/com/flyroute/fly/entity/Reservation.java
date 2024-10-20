package com.flyroute.fly.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private  Passenger passenger;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "seat_number")
    private String seatNumber;

    @Column(name = "cancellation_date")
    private LocalDate cancellationDate;

    @Column(name = "total_amount")
    private int totalAmount;

    @Column(name = "status")
    private String status;

    @Column(name = "confirmation_code")
    private String confirmationCode;
}
