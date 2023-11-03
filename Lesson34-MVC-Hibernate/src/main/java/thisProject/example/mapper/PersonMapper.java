package thisProject.example.mapper;

import org.mapstruct.Mapper;
import thisProject.example.dto.PersonEntityDto;
import thisProject.example.entity.PersonEntity;

@Mapper
public interface PersonMapper {

    PersonEntityDto fromPersonToPersonEntityDto(PersonEntity person);

    PersonEntity fromPersonDtoToPersonI(PersonEntityDto dto);
}
