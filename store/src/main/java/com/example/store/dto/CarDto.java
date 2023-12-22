package com.example.store.dto;

import com.example.store.model.Brand;
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
}