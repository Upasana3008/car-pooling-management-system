package com.project.carpooling.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	// Handling Custom ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", ex.getMessage());
		body.put("status", HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
	}
	
	
	// Handling Concurrency 
	@ExceptionHandler(ObjectOptimisticLockingFailureException.class)
	public ResponseEntity<?> handleConcurrencyTicket(ObjectOptimisticLockingFailureException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Seat already Booked at same time");
		body.put("status", HttpStatus.CONFLICT.value());
		
		return new ResponseEntity<>(body, HttpStatus.CONFLICT);
	}
	
	
	// Handling unexpected error
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGlobalException(Exception ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", LocalDateTime.now());
		body.put("message", "Error occured!" +ex.getMessage());
		body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    java.util.Map<String, Object> responseBody = new java.util.HashMap<>();
	    responseBody.put("timestamp", java.time.LocalDateTime.now());
	    responseBody.put("status", HttpStatus.BAD_REQUEST.value());

	    
	    java.util.Map<String, String> errors = new java.util.HashMap<>();
	    ex.getBindingResult().getFieldErrors().forEach(error -> {
	        errors.put(error.getField(), error.getDefaultMessage());
	    });

	    responseBody.put("errors", errors);

	    return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
	}
}
