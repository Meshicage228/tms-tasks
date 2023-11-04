package thisProject.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import thisProject.example.domain.enums.JobTitle;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
@RequestScope
public class PersonDto {
    private Integer id;
    @NotBlank(message = "Fill email!!!")
    private String p_email;
    private JobTitle p_title;
    @NotBlank(message = "Write your name!")
    private String p_name;
    @NotBlank(message = "Create your password!")
    private String p_password;
}
