package com.oop.carrentalspring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.oop.carrentalspring.enums.BookCarStatus;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;


import java.util.Date;

public class BookACarDto {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date fromDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private Date toDate;
    private Long days;
    private Long price;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookCarStatus bookCarStatus;
    private Long carId;
    private Long userId;
    private String username;
    private String email;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public Long getDays() {
		return days;
	}
	public void setDays(Long days) {
		this.days = days;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public BookCarStatus getBookCarStatus() {
		return bookCarStatus;
	}
	public void setBookCarStatus(BookCarStatus bookCarStatus) {
		this.bookCarStatus = bookCarStatus;
	}
	public Long getCarId() {
		return carId;
	}
	public void setCarId(Long carId) {
		this.carId = carId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "BookACarDto [id=" + id + ", fromDate=" + fromDate + ", toDate=" + toDate + ", days=" + days + ", price="
				+ price + ", bookCarStatus=" + bookCarStatus + ", carId=" + carId + ", userId=" + userId + ", username="
				+ username + ", email=" + email + "]";
	}
	public BookACarDto(Long id, Date fromDate, Date toDate, Long days, Long price, BookCarStatus bookCarStatus,
			Long carId, Long userId, String username, String email) {
		super();
		this.id = id;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.days = days;
		this.price = price;
		this.bookCarStatus = bookCarStatus;
		this.carId = carId;
		this.userId = userId;
		this.username = username;
		this.email = email;
	}
	public BookACarDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	
    
}
