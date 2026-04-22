package com.mvc.validator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Validator Spring Boot application.
 * 
 * <p>
 * This application initializes the Spring context and bootstraps
 * all configured components, including controllers, services,
 * and validation logic.
 * </p>
 */
@SpringBootApplication
public class ValidatorApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ValidatorApplication.class);
		
		// Optional: Customize startup behavior
		app.setLogStartupInfo(true);
		
		app.run(args);
	}
}
