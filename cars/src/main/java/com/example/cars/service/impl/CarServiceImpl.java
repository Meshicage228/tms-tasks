package com.example.cars.service.impl;

import com.example.cars.dto.CarDto;
import com.example.cars.exception.SomethingWentWrongException;
import com.example.cars.mapper.CarMapper;
import com.example.cars.model.CarEntity;
import com.example.cars.repository.CarRepository;
import com.example.cars.service.CarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
@Transactional
public class CarServiceImpl implements CarService {
    private final CarRepository repository;
    private final CarMapper mapper;

    @Override
    public CarDto save(CarDto dto) {
        CarEntity saved = repository.save(mapper.toEntity(dto));

        return mapper.toDto(saved);
    }

    @Override
    public CarDto update(Integer id , CarDto dto) {
        CarEntity user = repository.findById(id)
                .orElseThrow(() -> new SomethingWentWrongException("Didnt find user"));

        mapper.update(user, dto);

        return mapper.toDto(user);
    }

    @Override
    public CarDto get(Integer id) {
        CarEntity user = repository.findById(id)
                .orElseThrow(() -> new SomethingWentWrongException("Didnt find user"));

        return mapper.toDto(user);
    }

    @Override
    public void delete(Integer id) {
        CarEntity user = repository.findById(id)
                .orElseThrow(() -> new SomethingWentWrongException("Didnt find user"));

        repository.delete(user);
    }

    @Override
    public List<CarDto> getAll() {
        return mapper.toDtos(repository.findAll());
    }
}
