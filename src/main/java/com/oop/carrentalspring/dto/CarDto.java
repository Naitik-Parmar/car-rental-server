package com.oop.carrentalspring.dto;


import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.Date;


public class CarDto {
    private Long id;
    private String brand;
    private String color;
    private String name;
    private String type;
    private String transmission;
    private String description;
    private Long price;
    private Integer year;
    private MultipartFile image;
    private byte[] returnedImage;
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
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public byte[] getReturnedImage() {
		return returnedImage;
	}
	public void setReturnedImage(byte[] returnedImage) {
		this.returnedImage = returnedImage;
	}
	@Override
	public String toString() {
		return "CarDto [id=" + id + ", brand=" + brand + ", color=" + color + ", name=" + name + ", type=" + type
				+ ", transmission=" + transmission + ", description=" + description + ", price=" + price + ", year="
				+ year + ", image=" + image + ", returnedImage=" + Arrays.toString(returnedImage) + "]";
	}
	public CarDto(Long id, String brand, String color, String name, String type, String transmission,
			String description, Long price, Integer year, MultipartFile image, byte[] returnedImage) {
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
		this.returnedImage = returnedImage;
	}
	public CarDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    
}
