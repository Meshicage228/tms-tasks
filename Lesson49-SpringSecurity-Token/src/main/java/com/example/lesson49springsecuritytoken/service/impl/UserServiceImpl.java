package com.example.lesson49springsecuritytoken.service.impl;

import com.example.lesson49springsecuritytoken.dto.UserDto;
import com.example.lesson49springsecuritytoken.entity.UserEntity;
import com.example.lesson49springsecuritytoken.mapper.UserMapper;
import com.example.lesson49springsecuritytoken.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserDetailsService {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByName(username).orElse(null);
    }

    public UserDto save(UserDto dto) {
        UserEntity save = repository.save(mapper.toEntity(dto));
        return mapper.toDto(save);
    }
}
