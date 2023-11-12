package com.example.lesson39springbootdatajpa.dto;

import com.example.lesson39springbootdatajpa.domain.enums.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class FilmDto {

    private Integer id;
    @NotBlank(message = "error")
    private String title;

    private Genre genre;

    @NotBlank(message = "error")
    private String dateOfCreation;

    @Min(value = 0, message = "error") @Max(value = 10, message = "error")
    @NotNull(message = "error")
    private Float rating;
}
