package com.example.lesson51testenpoint.mapper;

import com.example.lesson51testenpoint.dto.OrderDto;
import com.example.lesson51testenpoint.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public interface OrderMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "money", source = "money")
    OrderDto toDto(OrderEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "title", source = "title")
    @Mapping(target = "money", source = "money")
    OrderEntity toEntity(OrderDto dto);
}
