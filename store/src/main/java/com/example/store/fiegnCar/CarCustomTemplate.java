package com.example.store.fiegnCar;

import com.example.store.dto.CarDto;
import com.example.store.exception.handler.StoreExceptionHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "${app.clients.user.name}", url = "${app.clients.user.url}", path = "${app.clients.user.path}", configuration = StoreExceptionHandler.class)
public interface CarCustomTemplate {
    @GetMapping
    List<CarDto> findAll();

    @GetMapping("/{id}")
    CarDto get(@PathVariable("id") Integer id);

    @PostMapping
    CarDto save(@RequestBody CarDto dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id);

    @PutMapping("/{id}")
    CarDto update(@PathVariable("id") Integer id,
                  @RequestBody CarDto dto);
}
