package com.project.carpooling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.carpooling.entities.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

	//Custom Method
	List<Booking> findByRiderId(Long riderId);
}
