package com.project.carpooling.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String source;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private Double price;

    // Many Rides to One User (Driver)
    @ManyToOne
    @JoinColumn(name = "driver_id", nullable = false)
    private User driver;

    // Concurrency ke liye version column 
    @Version
    private Long version;

    // Default Constructor
    public Ride() {}

    
    public Ride(String source, String destination, LocalDateTime departureTime, Integer availableSeats, Double price, User driver) {
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.availableSeats = availableSeats;
        this.price = price;
        this.driver = driver;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public LocalDateTime getDepartureTime() { return departureTime; }
    public void setDepartureTime(LocalDateTime departureTime) { this.departureTime = departureTime; }

    public Integer getAvailableSeats() { return availableSeats; }
    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public User getDriver() { return driver; }
    public void setDriver(User driver) { this.driver = driver; }

    public Long getVersion() { return version; }
    public void setVersion(Long version) { this.version = version; }
}