package com.project.carpooling.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carpooling.entities.Booking;
import com.project.carpooling.entities.Ride;
import com.project.carpooling.entities.User;
import com.project.carpooling.exception.ResourceNotFoundException;
import com.project.carpooling.repository.BookingRepository;
import com.project.carpooling.repository.RideRepository;
import com.project.carpooling.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private RideRepository rideRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	// Method for seat booking
	@Transactional
	public Booking bookRide(Long rideId, Long riderId, Integer seatsRequested) {
		
		// checking ride exist or not
		Ride ride = rideRepository.findById(rideId)
				.orElseThrow(() -> new ResourceNotFoundException("Ride Not Found"));
		
		// checking rider exist or not
		User rider = userRepository.findById(riderId)
				.orElseThrow(() -> new ResourceNotFoundException("Rider Not Found"));
		
		// checking required number of seats available or not
		if (ride.getAvailableSeats() < seatsRequested) {
			throw new RuntimeException("Sorry! required amount of seats are unavailable");
		}
		
		
		// updating no. of seats in ride
		ride.setAvailableSeats(ride.getAvailableSeats() - seatsRequested);
		rideRepository.save(ride);
		
		
		// creating new Booking Record
		Booking booking = new Booking();
		booking.setRide(ride);
		booking.setRider(rider);
		booking.setSeatsBooked(seatsRequested);
		booking.setBookingTime(LocalDateTime.now());
		booking.setStatus("CONFIRMED");
		
		// Saving details in booking table
		return bookingRepository.save(booking);
	}
}
