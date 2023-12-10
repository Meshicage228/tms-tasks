package com.example.store.controllers;

import com.example.store.dto.CarDto;
import com.example.store.service.impl.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/store/cars")
public class StoreController {
    private final CarServiceImpl service;
    @PostMapping
    public CarDto register(@RequestBody CarDto dto){
        return service.registerCar(dto);
    }
}
