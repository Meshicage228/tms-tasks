package thisProject.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import thisProject.example.domain.enums.JobTitle;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


@Component
@RequestScope
public class PersonDto {
    private Integer id;

    @NotBlank(message = "enter name!")
    private String p_name;
    @NotBlank(message = "enter password!")
    private String p_password;
    @NotBlank(message = "enter email!")
    private String p_email;
    private JobTitle p_title;

}
