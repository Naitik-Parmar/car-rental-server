package com.oop.carrentalspring.services.admin;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.oop.carrentalspring.dto.BookACarDto;
import com.oop.carrentalspring.dto.CarDto;
import com.oop.carrentalspring.dto.CarDtoListDto;
import com.oop.carrentalspring.dto.SearchCarDto;
import com.oop.carrentalspring.entity.BookACar;
import com.oop.carrentalspring.entity.Car;
import com.oop.carrentalspring.enums.BookCarStatus;
import com.oop.carrentalspring.repository.BookACarRepository;
import com.oop.carrentalspring.repository.CarRepository;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
    private  CarRepository carRepository;
	@Autowired
    private  BookACarRepository bookACarRepository;

    @Override
    public boolean postCar(CarDto carDto) throws IOException {
        boolean isSuccessful = false;

        try {
            Car car = new Car();
            car.setName(carDto.getName());
            car.setBrand(carDto.getBrand());
            car.setColor(carDto.getColor());
            car.setDescription(carDto.getDescription());
            car.setPrice(carDto.getPrice());
            car.setTransmission(carDto.getTransmission());
            car.setType(carDto.getType());
            car.setYear(carDto.getYear());
            car.setImage(carDto.getImage().getBytes());

            carRepository.save(car);

            isSuccessful = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return isSuccessful;
    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }


    @Override
    public boolean deleteCar(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            carRepository.deleteById(id);
            return true; 
        } else {
            return false; 
        }
    }

    
    @Override
    public CarDto getCarById(Long id) {
        return carRepository.findById(id).map(Car::getCarDto).orElse(null); 
    }


    @Override
    public boolean updateCar(Long id, CarDto carDto) throws IOException {
        Optional<Car> optionalCar = carRepository.findById(id);

        if (optionalCar.isPresent()) {
            Car existingCar = optionalCar.get();

            // Update only the fields that are provided
            existingCar.setImage(carDto.getImage() != null ? carDto.getImage().getBytes() : existingCar.getImage());
            existingCar.setPrice(carDto.getPrice() != null ? carDto.getPrice() : existingCar.getPrice());
            existingCar.setYear(carDto.getYear() != null ? carDto.getYear() : existingCar.getYear());
            existingCar.setType(carDto.getType() != null ? carDto.getType() : existingCar.getType());
            existingCar.setDescription(carDto.getDescription() != null ? carDto.getDescription() : existingCar.getDescription());
            existingCar.setTransmission(carDto.getTransmission() != null ? carDto.getTransmission() : existingCar.getTransmission());
            existingCar.setColor(carDto.getColor() != null ? carDto.getColor() : existingCar.getColor());
            existingCar.setName(carDto.getName() != null ? carDto.getName() : existingCar.getName());
            existingCar.setBrand(carDto.getBrand() != null ? carDto.getBrand() : existingCar.getBrand());

            carRepository.save(existingCar);
            return true;
        }

        return false;
    }

    
    

    @Override
    public List<BookACarDto> getBookings() {
        return bookACarRepository.findAll().stream().map(BookACar::getBookACarDto).collect(Collectors.toList());
    }

    @Override
    public boolean changeBookingStatus(Long id, String status) {
        Optional<BookACar> optionalBookACar = bookACarRepository.findById(id);

        if (optionalBookACar.isPresent()) {
            BookACar bookACar = optionalBookACar.get();

            if (Objects.equals(status, "Approve")) {
                bookACar.setBookCarStatus(BookCarStatus.APPROVED);
            } else {
                bookACar.setBookCarStatus(BookCarStatus.REJECTED);
            }

            bookACarRepository.save(bookACar);

            return true;
        }

        return false;
    }

    @Override
    public CarDtoListDto searchCar(SearchCarDto searchCarDto) {
        Car car = new Car();
        car.setBrand(searchCarDto.getBrand());
        car.setType(searchCarDto.getType());
        car.setTransmission(searchCarDto.getTransmission());
        car.setColor(searchCarDto.getColor());

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAll().withMatcher("brand", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase()).withMatcher("type", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase()).withMatcher("transmission", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase()).withMatcher("color", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());

        Example<Car> carExample = Example.of(car, exampleMatcher);

        List<Car> carList = carRepository.findAll(carExample);

        CarDtoListDto carDtoListDto = new CarDtoListDto();
        carDtoListDto.setCarDtoList(carList.stream().map(Car::getCarDto).collect(Collectors.toList()));

        return carDtoListDto;
    }
}
