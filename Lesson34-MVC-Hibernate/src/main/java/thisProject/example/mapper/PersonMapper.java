package thisProject.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import thisProject.example.dto.PersonDto;
import thisProject.example.entity.PersonEntity;

@Mapper(
        componentModel = "spring"
)
public interface PersonMapper {

    @Mapping(target = "p_name", source = "name")
    @Mapping(target = "p_email", source = "email")
    @Mapping(target = "p_password", source = "password")
    @Mapping(target = "p_title", source = "title")
    PersonDto fromEntityToDto(PersonEntity person);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "p_name")
    @Mapping(target = "email", source = "p_email")
    @Mapping(target = "password", source = "p_password")
    @Mapping(target = "title", source = "p_title")
    PersonEntity fromDtoToEntity(PersonDto dto);
}
