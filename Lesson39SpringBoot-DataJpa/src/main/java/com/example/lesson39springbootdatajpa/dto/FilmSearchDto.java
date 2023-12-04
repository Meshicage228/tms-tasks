package com.example.lesson39springbootdatajpa.dto;

import com.example.lesson39springbootdatajpa.domain.enums.Genre;
import lombok.Data;

@Data
public class FilmSearchDto {
    private String title;

    private Genre genre;

    private String dateOfCreation;

    private Float from;

    private Float to;
}
