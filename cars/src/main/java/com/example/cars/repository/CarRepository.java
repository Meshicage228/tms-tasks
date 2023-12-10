package com.example.cars.repository;

import com.example.cars.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {
}
