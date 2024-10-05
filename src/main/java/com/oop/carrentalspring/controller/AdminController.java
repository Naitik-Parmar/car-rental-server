


package com.oop.carrentalspring.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.oop.carrentalspring.Exceptions.ResourceNotFoundException;
import com.oop.carrentalspring.dto.BookACarDto;
import com.oop.carrentalspring.dto.CarDto;
import com.oop.carrentalspring.dto.SearchCarDto;
import com.oop.carrentalspring.services.admin.AdminService;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/car")
    public ResponseEntity<?> postCar(@ModelAttribute CarDto carDto) throws IOException {
        boolean isSuccessful = adminService.postCar(carDto);

        if (isSuccessful) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    
    @GetMapping("/cars")
    public ResponseEntity<?> getAllCars() {
        return ResponseEntity.ok(adminService.getAllCars());
    }


    
    @DeleteMapping("/car/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id) {
        try {
            boolean isDeleted = adminService.deleteCar(id);

            if (isDeleted) {
                return ResponseEntity.status(HttpStatus.OK).body("Car with ID " + id + " has been deleted successfully.");
            } else {
                
                throw new ResourceNotFoundException("Car with ID " + id + " not found.");
            }
        } catch (ResourceNotFoundException e) {
           
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while deleting the car.");
        }
    }



    @GetMapping("/car/{id}")
    public ResponseEntity<?> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(adminService.getCarById(id));
    }

    
    @PutMapping("/car/{id}")
    public ResponseEntity<String> updateCar(@PathVariable Long id, @RequestBody CarDto carDto) throws IOException {
        try {
            boolean isSuccessful = adminService.updateCar(id, carDto);

            if (isSuccessful) {
                return ResponseEntity.status(HttpStatus.OK).build();
            } else {
                
                throw new ResourceNotFoundException("Car with ID " + id + " not found.");
            }
        } catch (ResourceNotFoundException e) {
            
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
           
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred while updating the car.");
        }
    }

    

    @GetMapping("/car/bookings")
    public ResponseEntity<List<BookACarDto>> getBookings() {
        return ResponseEntity.ok(adminService.getBookings());
    }

    @GetMapping("/car/booking/{bookingId}/{status}")
    public ResponseEntity<Void> changeBookingStatus(@PathVariable Long bookingId, @PathVariable String status) {
        boolean isSuccessful = adminService.changeBookingStatus(bookingId, status);

        if (isSuccessful) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        throw new ResourceNotFoundException("Booking with ID " + bookingId + " not found.");
    }

    @PostMapping("/car/search")
    public ResponseEntity<?> searchCar(@RequestBody SearchCarDto searchCarDto) {
        return ResponseEntity.ok(adminService.searchCar(searchCarDto));
    }
}
