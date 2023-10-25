package project.comm.userService.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import project.comm.domain.User;
import project.comm.userService.UserService;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final JdbcTemplate template;
    @Override
    public void save(User user) {
        String email = user.getEmail();
        String jobTitle = String.valueOf(user.getJobTitle());
        String password = user.getPassword();
        String name = user.getName();
        String query = "insert into users (name, email, jobtitle, password) values ('%s', '%s', '%s', '%s')";
        String format = String.format(query, name, email, jobTitle, password);
        template.execute(format);
    }

    @Override
    public List<User> showUsers(){
        return template.query("select * from users", new UserMapper());
    }
}
