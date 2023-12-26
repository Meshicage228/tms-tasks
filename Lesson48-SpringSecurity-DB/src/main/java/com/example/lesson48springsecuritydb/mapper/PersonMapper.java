package com.example.lesson48springsecuritydb.mapper;

import com.example.lesson48springsecuritydb.dto.PersonDto;
import com.example.lesson48springsecuritydb.model.PersonEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Mapper(
        componentModel = "spring"
)
public abstract class PersonMapper {
    @Autowired
    private BCryptPasswordEncoder encoder;

    @Mapping(target = "username", source = "username")
    @Mapping(target = "perm", defaultValue = "ROLE_USER")
    @Mapping(target = "pass", expression = "java(encodePassword(dto))")
    public abstract PersonEntity toEntity(PersonDto dto);

    @Mapping(target = "username", source = "username")
    @Mapping(target = "pass", source = "pass")
    @Mapping(target = "perm", source = "perm")
    public abstract PersonDto toDto(PersonEntity entity);

    String encodePassword(PersonDto source) {
        return encoder.encode(source.getPass());
    }

}
