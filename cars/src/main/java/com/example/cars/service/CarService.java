package com.example.cars.service;

import com.example.cars.dto.CarDto;

import java.util.List;

public interface CarService {
    CarDto save(CarDto dto);
    CarDto update(Integer id , CarDto dto);
    CarDto get(Integer id);
    void delete(Integer id);
    List<CarDto> getAll();
}
