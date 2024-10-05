package com.oop.carrentalspring.services.admin;

import java.io.IOException;
import java.util.List;

import com.oop.carrentalspring.dto.BookACarDto;
import com.oop.carrentalspring.dto.CarDto;
import com.oop.carrentalspring.dto.CarDtoListDto;
import com.oop.carrentalspring.dto.SearchCarDto;

public interface AdminService {
    boolean postCar(CarDto carDto) throws IOException;

    List<CarDto> getAllCars();

    boolean deleteCar(Long id);

    CarDto getCarById(Long id);

    boolean updateCar(Long id, CarDto carDto) throws IOException;

    List<BookACarDto> getBookings();


    boolean changeBookingStatus(Long id, String status);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);
}
