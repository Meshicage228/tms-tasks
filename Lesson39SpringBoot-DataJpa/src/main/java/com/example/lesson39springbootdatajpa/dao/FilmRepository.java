package com.example.lesson39springbootdatajpa.dao;

import com.example.lesson39springbootdatajpa.entity.FilmEntity;
import jakarta.transaction.Transactional;
import org.hibernate.annotations.DialectOverride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE FilmEntity SET rating = :rating WHERE id = :id")
    void updateRatingById(Float rating, Integer id);

    @Query(value = "SELECT* FROM films ORDER BY rating ASC", nativeQuery = true)
    List<FilmEntity> findAllOrderByRating();
}
