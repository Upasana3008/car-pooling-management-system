package com.project.carpooling.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carpooling.dto.UserRegisterDTO;
import com.project.carpooling.dto.UserResponseDTO;
import com.project.carpooling.entities.User;
import com.project.carpooling.exception.ResourceNotFoundException;
import com.project.carpooling.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired 
	private UserRepository userRepository;
	
	// 1. User Registration method
	public UserResponseDTO registerUser(UserRegisterDTO dto) {
		Optional<User> existingUser = userRepository.findByEmail(dto.getEmail());
		if (existingUser.isPresent()) {
			throw new RuntimeException("Email already registered");
		}
		User user = new User();
	    user.setName(dto.getName());
	    user.setEmail(dto.getEmail());
	    user.setPassword(dto.getPassword());
	    user.setPhone(dto.getPhone());
	    
	    User savedUser = userRepository.save(user);
	    
	    
	    UserResponseDTO response = new UserResponseDTO();
	    response.setId(savedUser.getId());
	    response.setName(savedUser.getName());
	    response.setEmail(savedUser.getEmail());
	    response.setPhone(savedUser.getPhone());

	    return response;
	}

	
	
	// 2. User Login Method
	public User loginUser(String email, String password) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User not Found"));
		
		if(!user.getPassword().equals(password)) {
			throw new RuntimeException("Incorrect Password");
		}
		
		return user;
		}
	}

