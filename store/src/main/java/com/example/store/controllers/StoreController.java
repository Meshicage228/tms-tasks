package com.example.store.controllers;

import com.example.store.dto.CarDto;
import com.example.store.exception.ExceptionDetails;
import com.example.store.service.impl.CarServiceImpl;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RequiredArgsConstructor
@RestController
@OpenAPIDefinition(info = @Info(
        title = "This is store controller to operate with cars",
        description = "This controller uses CRUD and sends http-status",
        version = "1.0",
        summary = "Before using this controller make sure, that you have cars already, " +
                  "if you didnt, you will get an exception with delete and get-by-id endpoints"
))
@RequestMapping("/store/cars")
public class StoreController {
    private final CarServiceImpl service;
    @PostMapping
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
    @Operation(tags = "crud-operations",
                responses = {
                    @ApiResponse(
                            content = @Content(array = @ArraySchema(
                                    schema = @Schema(implementation = CarDto.class)))
                    )
                })
    public ResponseEntity<List<CarDto>> getAll(){
        return ok(service.showAllCars());
    }
    @GetMapping("/{id}")
    @Operation(tags = "crud-operations")
    public ResponseEntity<CarDto> getById(@PathVariable("id") Integer id){
        return ok(service.getById(id));
    }
    @DeleteMapping("/{id}")
    @Operation(tags = "crud-operations")
    public void delete(@PathVariable("id") Integer id){
        service.delete(id);
    }
}
