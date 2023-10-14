package project.comm.userService;

import project.comm.domain.User;
import project.comm.exceptions.MissingUserInputException;

public interface UserService {
    void save(User user);
    void showUser(User user);
}
