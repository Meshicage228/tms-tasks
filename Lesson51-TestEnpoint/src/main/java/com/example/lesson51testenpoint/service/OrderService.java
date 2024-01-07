package com.example.lesson51testenpoint.service;

import com.example.lesson51testenpoint.dto.OrderDto;
import com.example.lesson51testenpoint.entity.OrderEntity;
import com.example.lesson51testenpoint.mapper.OrderMapper;
import com.example.lesson51testenpoint.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor

@Service
public class OrderService {
    OrderRepository repository;
    OrderMapper mapper;
    public OrderDto save(OrderDto dto){
        OrderEntity saved = repository.save(mapper.toEntity(dto));

        return mapper.toDto(saved);
    }
}
