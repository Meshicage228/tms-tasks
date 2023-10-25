package project.comm.userService;

import project.comm.domain.User;

import java.util.List;

public interface UserService {
    void save(User user);
    List<User> showUsers();
}
