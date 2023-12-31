package com.example.lesson39springbootdatajpa.mappers;


import com.example.lesson39springbootdatajpa.dto.FilmDto;
import com.example.lesson39springbootdatajpa.entity.FilmEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring"
)

public interface FilmMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "dateOfCreation", source = "dateOfCreation")
    @Mapping(target = "rating", source = "rating")
    FilmDto toDto(FilmEntity filmEntity);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "dateOfCreation", source = "dateOfCreation")
    @Mapping(target = "rating", source = "rating")
    FilmEntity toEntity(FilmDto filmDto);

    List<FilmDto> toDtos(List<FilmEntity> employees);
}
