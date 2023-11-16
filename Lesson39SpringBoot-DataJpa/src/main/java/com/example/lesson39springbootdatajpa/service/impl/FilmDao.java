package com.example.lesson39springbootdatajpa.service.impl;

import com.example.lesson39springbootdatajpa.repository.FilmRepository;
import com.example.lesson39springbootdatajpa.entity.FilmEntity;
import com.example.lesson39springbootdatajpa.service.FilmService;
import jakarta.transaction.Transactional;
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

    @Transactional
    public void updateRatingById(Float rating, Integer id) {
        repository.updateRatingById(rating, id);
    }
    public List<FilmEntity> findAllOrderByRating(){
        return repository.findAllOrderByRating();
    }

}
