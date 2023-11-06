package thisProject.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import thisProject.example.domain.enums.JobTitle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
@RequestScope
public class PersonDto {
    private Integer id;
    @NotNull(message = "Fill email!!!")
    @NotBlank(message = "Fill email!!!")
    private String p_email;
    private JobTitle p_title;
    @NotNull(message = "Write your name!")
    @NotBlank(message = "Write your name!")
    private String p_name;
    @NotNull(message = "Create your password!")
    @NotBlank(message = "Create your password!")
    private String p_password;
}
