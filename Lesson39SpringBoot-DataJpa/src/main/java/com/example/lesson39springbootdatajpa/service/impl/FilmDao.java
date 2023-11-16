package com.example.lesson39springbootdatajpa.service.impl;

import com.example.lesson39springbootdatajpa.dao.FilmRepository;
import com.example.lesson39springbootdatajpa.entity.FilmEntity;
import com.example.lesson39springbootdatajpa.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilmDao implements FilmService {
    private final FilmRepository repository;
    @Override
    public List<FilmEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void save(FilmEntity filmEntity) {
        repository.save(filmEntity);
    }
}
