package com.project.carpooling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carpooling.entities.Ride;
import com.project.carpooling.entities.User;
import com.project.carpooling.exception.ResourceNotFoundException;
import com.project.carpooling.repository.RideRepository;
import com.project.carpooling.repository.UserRepository;

@Service
public class RideService {

	
	@Autowired
	private RideRepository rideRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	// 1. Ride create (offering ride)
	public Ride createRide(Ride ride , Long driverId) {
		User driver = userRepository.findById(driverId)
				.orElseThrow(() -> new ResourceNotFoundException("Driver not found, incorrect ID"));
		
		ride.setDriver(driver);
		
		return rideRepository.save(ride);
	}
	
	
	
	// 2. Method for searching rides
	public List<Ride> searchRides(String source, String destination) {
		return rideRepository.findBySourceAndDestination(source, destination);
	}
}
