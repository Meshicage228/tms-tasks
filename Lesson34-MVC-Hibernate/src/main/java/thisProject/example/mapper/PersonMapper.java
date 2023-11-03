package thisProject.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import thisProject.example.dto.PersonDto;
import thisProject.example.entity.PersonEntity;

@Mapper(
        componentModel = "spring"
)
public interface PersonMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "title", source = "title")
    PersonDto fromEntityToDto(PersonEntity person);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "title", source = "title")
    PersonEntity fromDtoToEntity(PersonDto dto);
}
