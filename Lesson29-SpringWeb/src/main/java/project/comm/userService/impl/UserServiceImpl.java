package project.comm.userService.impl;

import org.springframework.stereotype.Component;
import project.comm.domain.CustomDB;
import project.comm.domain.User;
import project.comm.userService.UserService;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public void save(User user) {
        CustomDB.userList.add(user);
    }

    @Override
    public void showUser(User user){
    }
}
