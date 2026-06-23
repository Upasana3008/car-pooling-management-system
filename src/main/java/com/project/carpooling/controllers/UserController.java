package com.project.carpooling.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.carpooling.dto.UserRegisterDTO;
import com.project.carpooling.dto.UserResponseDTO;
import com.project.carpooling.entities.User;
import com.project.carpooling.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	// Register API
	@PostMapping("/register")
	public ResponseEntity<UserResponseDTO> regsiterUser(@Valid @RequestBody UserRegisterDTO dto) {
			UserResponseDTO response = userService.registerUser(dto);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
		
	
	
	
	// Login API
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password) {
			//User user = userService.loginUser(email, password);
			//return new ResponseEntity<>(user, HttpStatus.OK);
		return new ResponseEntity<>("Login Successful (Temporary)", HttpStatus.OK);
	}
		
	
}
