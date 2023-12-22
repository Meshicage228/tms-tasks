package com.example.cars.mapper;

import com.example.cars.dto.CarDto;
import com.example.cars.model.CarEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "mileage", source = "mileage")
    CarDto toDto (CarEntity entity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "mileage", source = "mileage")
    CarEntity toEntity(CarDto dto);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "brand", source = "brand")
    @Mapping(target = "mileage", source = "mileage")
    void update(@MappingTarget CarEntity entity, CarDto dto);

    List<CarDto> toDtos (List<CarEntity> entities);
}
