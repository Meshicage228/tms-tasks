package com.example.lesson48springsecuritydb.service;

import com.example.lesson48springsecuritydb.dto.PersonDto;
import com.example.lesson48springsecuritydb.model.PersonEntity;

import java.util.Optional;

public interface PersonService {
    PersonDto save(PersonDto dto);
}
