package project.comm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
@RequestScope
public class User {
    @NotBlank(message = "Fill email!!!")
    private String email;
    private JobTitle jobTitle;
    @NotBlank(message = "Write your name!")
    private String name;
    @NotBlank(message = "Create your password!")
    private String password;

    public User(String email, JobTitle jobTitle, String name) {
        this.email = email;
        this.jobTitle = jobTitle;
        this.name = name;
    }
}
