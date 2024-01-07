package com.example.lesson49springsecuritytoken.repository;

import com.example.lesson49springsecuritytoken.dto.UserDto;
import com.example.lesson49springsecuritytoken.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByName(String username);
}
