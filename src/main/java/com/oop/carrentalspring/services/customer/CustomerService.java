package com.oop.carrentalspring.services.customer;

import java.util.List;

import com.oop.carrentalspring.dto.BookACarDto;
import com.oop.carrentalspring.dto.CarDto;
import com.oop.carrentalspring.dto.CarDtoListDto;
import com.oop.carrentalspring.dto.SearchCarDto;

public interface CustomerService {
    List<CarDto> getAllCars();

    boolean bookACar(BookACarDto bookACarDto);

    CarDto getCarById(Long id);

    List<BookACarDto> getBookingsByUserId(Long id);

    CarDtoListDto searchCar(SearchCarDto searchCarDto);
}
