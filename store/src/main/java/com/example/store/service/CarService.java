package com.example.store.service;

import com.example.store.dto.CarDto;

import java.util.List;

public interface CarService {
    CarDto registerCar(CarDto dto);

    List<CarDto> showAllCars();

    CarDto getById(Integer id);

    void delete(Integer id);
}
