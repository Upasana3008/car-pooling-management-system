package com.project.carpooling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.carpooling.entities.Ride;

public interface RideRepository extends JpaRepository<Ride, Long>{

	//Custom Method
	List<Ride> findBySourceAndDestination(String Source, String Destination);
}
