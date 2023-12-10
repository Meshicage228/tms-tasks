package com.example.store.service.impl;

import com.example.store.dto.CarDto;
import com.example.store.fiegnCar.CarCustomTemplate;
import com.example.store.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarCustomTemplate template;
    @Override
    public CarDto registerCar(CarDto dto) {
        return template.save(dto);
    }

    @Override
    public List<CarDto> showAllCars() {
        return template.findAll();
    }

    @Override
    public CarDto getById(Integer id) {
        return template.get(id);
    }

    @Override
    public void delete(Integer id) {
        template.delete(id);
    }
}
