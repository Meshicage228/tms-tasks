package com.example.lesson48springsecuritydb.repository;

import com.example.lesson48springsecuritydb.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    Optional<PersonEntity> findByUsername(String username);
}
