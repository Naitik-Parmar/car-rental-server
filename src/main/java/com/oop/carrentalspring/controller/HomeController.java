package com.oop.carrentalspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oop.carrentalspring.Exceptions.ResourceNotFoundException;
import com.oop.carrentalspring.dto.CarDto;
import com.oop.carrentalspring.dto.SearchCarDto;
import com.oop.carrentalspring.services.customer.CustomerService;

@RestController
@RequestMapping("/api/home")
public class HomeController {
	
	@Autowired
    private  CustomerService customerService;
	
	   @GetMapping("/cars")
	    public ResponseEntity<List<CarDto>> getAllCars() {
	        return ResponseEntity.ok(customerService.getAllCars());
	    }
	   @PostMapping("/car/search/cars")
	    public ResponseEntity<?> searchCar(@RequestBody SearchCarDto searchCarDto) {
	        return ResponseEntity.ok(customerService.searchCar(searchCarDto));
	    }
	    @GetMapping("/car/{carId}")
	    public ResponseEntity<CarDto> getCarById(@PathVariable Long carId) {
	        CarDto carDto = customerService.getCarById(carId);

	        if (carDto != null) {
	            return ResponseEntity.ok(carDto);
	        }
	        throw new ResourceNotFoundException("Car with ID " + carId + " not found.");
	    }
}
