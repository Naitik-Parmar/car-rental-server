package com.oop.carrentalspring.entity;

import jakarta.persistence.*;


import java.util.Arrays;
import com.oop.carrentalspring.dto.CarDto;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String color;
    private String name;
    private String type;
    private String transmission;
    private String description;
    private Long price;
    private Integer year;

    @Column(columnDefinition = "longblob")
    private byte[] image;
    
    

    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getTransmission() {
		return transmission;
	}



	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Long getPrice() {
		return price;
	}



	public void setPrice(Long price) {
		this.price = price;
	}



	public Integer getYear() {
		return year;
	}



	public void setYear(Integer year) {
		this.year = year;
	}



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", color=" + color + ", name=" + name + ", type=" + type
				+ ", transmission=" + transmission + ", description=" + description + ", price=" + price + ", year="
				+ year + ", image=" + Arrays.toString(image) + "]";
	}



	public CarDto getCarDto() {
        CarDto carDto = new CarDto();
        carDto.setId(id);
        carDto.setName(name);
        carDto.setBrand(brand);
        carDto.setColor(color);
        carDto.setPrice(price);
        carDto.setDescription(description);
        carDto.setType(type);
        carDto.setTransmission(transmission);
        carDto.setYear(year);
        carDto.setReturnedImage(image);
        return carDto;
    }



	public Car(Long id, String brand, String color, String name, String type, String transmission, String description,
			Long price, Integer year, byte[] image) {
		super();
		this.id = id;
		this.brand = brand;
		this.color = color;
		this.name = name;
		this.type = type;
		this.transmission = transmission;
		this.description = description;
		this.price = price;
		this.year = year;
		this.image = image;
	}



	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
