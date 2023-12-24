package com.example.lesson48springsecuritydb.service.impl;

import com.example.lesson48springsecuritydb.dto.PersonDto;
import com.example.lesson48springsecuritydb.mapper.PersonMapper;
import com.example.lesson48springsecuritydb.model.PersonEntity;
import com.example.lesson48springsecuritydb.repository.PersonRepository;
import com.example.lesson48springsecuritydb.service.PersonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DBUserDetailsService implements UserDetailsService, PersonService {
    private final PersonRepository repository;
    private final PersonMapper mapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElse(null);
    }

    @Override
    @Transactional
    public PersonDto save(PersonDto dto) {
        PersonEntity entity = mapper.toEntity(dto);
        PersonEntity save = repository.save(entity);
        return mapper.toDto(save);
    }
}
