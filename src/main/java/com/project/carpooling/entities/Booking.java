package com.project.carpooling.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @ManyToOne
    @JoinColumn(name = "ride_id", nullable = false)
    private Ride ride;

   
    @ManyToOne
    @JoinColumn(name = "rider_id", nullable = false)
    private User rider;

    @Column(nullable = false)
    private Integer seatsBooked;

    @Column(nullable = false)
    private LocalDateTime bookingTime;

    @Column(nullable = false)
    private String status; // CONFIRMED, CANCELLED

    // Default Constructor
    public Booking() {}

    
    public Booking(Ride ride, User rider, Integer seatsBooked, LocalDateTime bookingTime, String status) {
        this.ride = ride;
        this.rider = rider;
        this.seatsBooked = seatsBooked;
        this.bookingTime = bookingTime;
        this.status = status;
    }

    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Ride getRide() { return ride; }
    public void setRide(Ride ride) { this.ride = ride; }

    public User getRider() { return rider; }
    public void setRider(User rider) { this.rider = rider; }

    public Integer getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(Integer seatsBooked) { this.seatsBooked = seatsBooked; }

    public LocalDateTime getBookingTime() { return bookingTime; }
    public void setBookingTime(LocalDateTime bookingTime) { this.bookingTime = bookingTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}