package com.example.store.service.impl;

import com.example.store.dto.CarDto;
import com.example.store.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final RestTemplate template;
    @Override
    public CarDto registerCar(CarDto dto) {
        var car = template.postForEntity("http://127.0.0.1:8081/cars", dto, CarDto.class);

        return car.getBody();
    }
}
