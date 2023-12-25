package com.example.store.controllers;

import com.example.store.dto.CarDto;
import com.example.store.service.impl.CarServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    @Operation(tags = "crud-operations",
               description = "after running this app, better to create car first, or you will get an exception with get-by-id an delete endpoints",
               summary = "to create car",
               responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "car was created successfully",
                            content = {
                                    @Content(schema = @Schema(implementation = CarDto.class),
                                             mediaType = "application/json")
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Brand doesnt exist",
                            content = {
                                    @Content(mediaType = "application/json",
                                             schema = @Schema(implementation = ExceptionDetails.class))
                            }
                    )
               }
    )
    public ResponseEntity<CarDto> register(@RequestBody CarDto dto){
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
