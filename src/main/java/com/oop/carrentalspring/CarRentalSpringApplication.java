package com.oop.carrentalspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.oop.carrentalspring.services.jwt", "com.oop.carrentalspring"})
public class CarRentalSpringApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(CarRentalSpringApplication.class, args);
        } catch (Exception e) {
            System.err.println("Error starting Spring Boot application: " + e.getMessage());
        }
    }
}

