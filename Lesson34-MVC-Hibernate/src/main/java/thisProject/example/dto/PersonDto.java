package thisProject.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import thisProject.example.domain.enums.JobTitle;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PersonDto {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private JobTitle title;
}
