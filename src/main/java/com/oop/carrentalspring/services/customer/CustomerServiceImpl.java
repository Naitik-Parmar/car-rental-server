package com.oop.carrentalspring.services.customer;

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
import com.oop.carrentalspring.entity.User;
import com.oop.carrentalspring.enums.BookCarStatus;
import com.oop.carrentalspring.repository.BookACarRepository;
import com.oop.carrentalspring.repository.CarRepository;
import com.oop.carrentalspring.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
    private  CarRepository carRepository;
	@Autowired
    private  UserRepository userRepository;
	@Autowired
    private  BookACarRepository bookACarRepository;

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public boolean bookACar(BookACarDto bookACarDto) {
    	
    	 Optional<Car> optionalCar = carRepository.findById(bookACarDto.getCarId());
         Optional<User> optionalUser = userRepository.findById(bookACarDto.getUserId());

         if (optionalCar.isPresent() && optionalUser.isPresent()) {
             Car existingCar = optionalCar.get();
             User existingUser = optionalUser.get();

            
             BookACar bookACar = new BookACar();
             bookACar.setUser(existingUser);
             bookACar.setCar(existingCar);
             bookACar.setBookCarStatus(BookCarStatus.PENDING);
             bookACar.setFromDate(bookACarDto.getFromDate());
             bookACar.setToDate(bookACarDto.getToDate());

             if (bookACarDto.getFromDate() == null || bookACarDto.getToDate() == null) {
                 throw new IllegalArgumentException("From date and To date cannot be null");
             }

             
             long diffInMilliSeconds = bookACarDto.getToDate().getTime() - bookACarDto.getFromDate().getTime();
             long days = TimeUnit.MILLISECONDS.toDays(diffInMilliSeconds);

             if (days < 0) {
                 throw new IllegalArgumentException("To date must be after From date");
             }

             bookACar.setDays(days);
             bookACar.setPrice(days * existingCar.getPrice());

             bookACarRepository.save(bookACar);
             return true;
         }

         return false;
    
    }

    @Override
    public CarDto getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }

    @Override
    public List<BookACarDto> getBookingsByUserId(Long userId) {
        return bookACarRepository.findAllByUserId(userId).stream().map(BookACar::getBookACarDto).collect(Collectors.toList());
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
