package dto;

import domain.Readiness;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TaskSearchDto {
    private String nameOfTask;
    private String taskDescription;
    private Readiness readiness;
}
