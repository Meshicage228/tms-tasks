package com.example.store.controllers;

import com.example.store.dto.CarDto;
import com.example.store.service.impl.CarServiceImpl;
import com.example.store.validation.CheckBadWordValidation;
import com.example.store.validation.markers.OnCreate;
import com.example.store.validation.markers.OnUpdate;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store/cars")
public class StoreController {
    private final CarServiceImpl service;
    @PostMapping
    public ResponseEntity<CarDto> register(@Validated(value = OnCreate.class) @Valid @RequestBody CarDto dto){
        return ok(service.registerCar(dto));
    }
    @GetMapping
    public ResponseEntity<List<CarDto>> getAll(){
        return ok(service.showAllCars());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getById(@PathVariable("id") Integer id){
        return ok(service.getById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<CarDto> update(@Validated(value = OnUpdate.class) @Valid @RequestBody CarDto dto,
                         @PathVariable("id") Integer id){
        return ok(service.update(id, dto));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }
}
