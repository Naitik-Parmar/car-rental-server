package com.oop.carrentalspring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oop.carrentalspring.dto.BookACarDto;
import com.oop.carrentalspring.enums.BookCarStatus;

import jakarta.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
public class BookACar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore // @JsonIgnore is used to ignore the user field when serializing the object to JSON.
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Car car;
    
    

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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Car getCar() {
		return car;
	}



	public void setCar(Car car) {
		this.car = car;
	}



	@Override
	public String toString() {
		return "BookACar [id=" + id + ", fromDate=" + fromDate + ", toDate=" + toDate + ", days=" + days + ", price="
				+ price + ", bookCarStatus=" + bookCarStatus + ", user=" + user + ", car=" + car + "]";
	}



	public BookACarDto getBookACarDto() {
        BookACarDto bookACarDto = new BookACarDto();
        bookACarDto.setId(this.id);
        bookACarDto.setDays(this.days);
        bookACarDto.setBookCarStatus(this.bookCarStatus);
        bookACarDto.setPrice(this.price);
        bookACarDto.setToDate(this.toDate);
        bookACarDto.setFromDate(this.fromDate);
        bookACarDto.setEmail(this.user.getEmail());
        bookACarDto.setUsername(this.user.getName());
        bookACarDto.setUserId(this.user.getId());
        bookACarDto.setCarId(this.car.getId());
        return bookACarDto;
    }
	
	
}
