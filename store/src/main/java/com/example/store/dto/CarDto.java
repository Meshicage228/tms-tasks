package com.example.store.dto;

import com.example.store.model.Brand;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Car dto object",
        description = "Class designed to be accepted from ui"

)
public class CarDto {
    private Integer id;
    @Schema(name = "brand", example = "AUDI", description = "choose one of following brands : ", required = true)
    private Brand brand ;
    @NotNull
    @Min(value = 0)
    @Max(value = 4000)
    @Schema(name = "mileage", example = "1200", description = "add positive mileage", minimum = "0", maximum = "4000", required = true)
    private Float mileage;
}