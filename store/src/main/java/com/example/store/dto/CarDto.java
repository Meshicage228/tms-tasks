package com.example.store.dto;

import com.example.store.model.Brand;
import com.example.store.validation.CheckBadWordValidation;
import com.example.store.validation.markers.OnCreate;
import com.example.store.validation.markers.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CarDto {
    private Integer id;
    private Brand brand ;
    private Float mileage;
    @CheckBadWordValidation(groups = {OnCreate.class, OnUpdate.class})
    private String description;
}