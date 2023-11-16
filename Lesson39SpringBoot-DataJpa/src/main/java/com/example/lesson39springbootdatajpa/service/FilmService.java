package com.example.lesson39springbootdatajpa.service;

import com.example.lesson39springbootdatajpa.entity.FilmEntity;

import java.util.List;

public interface FilmService {
    List<FilmEntity> getAll();
    void deleteById(Integer id);
    void save(FilmEntity filmEntity);
}
