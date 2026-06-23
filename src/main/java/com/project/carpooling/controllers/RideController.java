package com.project.carpooling.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.carpooling.entities.Ride;
import com.project.carpooling.service.RideService;

@RestController
@RequestMapping("/api/rides")
public class RideController {
	
	@Autowired
	private RideService rideService;
	
	
	// Create Ride API
	@PostMapping("/create/{driverId}")
	public ResponseEntity<?> createRide(@RequestBody Ride ride, @PathVariable Long driverId) {
		try {
			Ride newRide = rideService.createRide(ride, driverId);
			return new ResponseEntity<>(newRide, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
	// Search Rides API
	@GetMapping("/search")
	public ResponseEntity<?> searchRides(@RequestParam String source, @RequestParam String destination) {
		try {
			List<Ride> rides = rideService.searchRides(source, destination);
			return new ResponseEntity<>(rides, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
