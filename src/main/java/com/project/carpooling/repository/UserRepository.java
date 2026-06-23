package com.project.carpooling.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.carpooling.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	// Custom Method
	Optional<User> findByEmail(String email);
}
