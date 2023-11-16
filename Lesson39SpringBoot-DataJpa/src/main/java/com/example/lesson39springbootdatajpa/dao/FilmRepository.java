package com.example.lesson39springbootdatajpa.dao;

import com.example.lesson39springbootdatajpa.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
}
