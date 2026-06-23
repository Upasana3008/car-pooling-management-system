package com.project.carpooling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
	    info = @Info(
	        title = "Carpooling & Ride-Sharing API",
	        version = "1.0",
	        description = "This API handles the backend core engine for an Enterprise Carpooling Platform. It includes secure JWT authentication, optimized ride search with pagination, and strict concurrency control using Optimistic Locking to prevent seat overbooking."
	    )
	)
public class CarpoolingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarpoolingApplication.class, args);
	}

}
