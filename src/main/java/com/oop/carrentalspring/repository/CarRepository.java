package com.oop.carrentalspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oop.carrentalspring.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
