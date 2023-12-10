package com.example.cars.controllers;

import com.example.cars.dto.CarDto;
import com.example.cars.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService service;
    @GetMapping("/{id}")
    public CarDto get(@PathVariable("id") Integer id){
        return service.get(id);
    }

    @GetMapping
    public List<CarDto> findAll(){
        return service.getAll();
    }

    @PostMapping
    public CarDto save(@RequestBody CarDto dto){
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public CarDto update(@PathVariable("id") Integer id,
                         @RequestBody CarDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }
}
