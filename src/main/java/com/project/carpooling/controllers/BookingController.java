package com.project.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.carpooling.entities.Booking;
import com.project.carpooling.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	
	// Book Ride API
	@PostMapping("/ride/{rideId}/rider/{riderId}")
	public ResponseEntity<?> bookRide(@PathVariable Long rideId,
									  @PathVariable Long riderId,
									  @RequestParam Integer seats) {
		try {
			
			Booking booking = bookingService.bookRide(rideId, riderId, seats);
			return new ResponseEntity<>(booking, HttpStatus.CREATED);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
