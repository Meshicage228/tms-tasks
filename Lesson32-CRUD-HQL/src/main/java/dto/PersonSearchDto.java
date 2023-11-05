package dto;

import domain.Sex;
import entity.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonSearchDto {
    private String name;
    private LocalDate dateOfBirth;
    private Sex sex;
    private List<TaskEntity> entityList;
}
