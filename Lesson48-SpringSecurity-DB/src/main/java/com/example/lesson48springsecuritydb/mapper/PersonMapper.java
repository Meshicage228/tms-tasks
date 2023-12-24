package com.example.lesson48springsecuritydb.mapper;

import com.example.lesson48springsecuritydb.dto.PersonDto;
import com.example.lesson48springsecuritydb.model.PersonEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Mapper(
        componentModel = "spring"
)
public interface PersonMapper {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Mapping(target = "username", source = "username")
    @Mapping(target = "perm", defaultValue = "ROLE_USER")
    @Mapping(target = "pass", expression = "java(encodePassword(dto.getPass()))")
    PersonEntity toEntity(PersonDto dto);

    @Mapping(target = "username", source = "username")
    @Mapping(target = "pass", source = "pass")
    @Mapping(target = "perm", source = "perm")
    PersonDto toDto(PersonEntity entity);

    @AfterMapping
    default String encodePassword(String source) {
        return encoder.encode(source);
    }

}
