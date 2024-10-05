package com.oop.carrentalspring.dto;



import java.util.List;


public class CarDtoListDto {
    private List<CarDto> carDtoList;

	public List<CarDto> getCarDtoList() {
		return carDtoList;
	}

	public void setCarDtoList(List<CarDto> carDtoList) {
		this.carDtoList = carDtoList;
	}

	@Override
	public String toString() {
		return "CarDtoListDto [carDtoList=" + carDtoList + "]";
	}

	
    
    
}
