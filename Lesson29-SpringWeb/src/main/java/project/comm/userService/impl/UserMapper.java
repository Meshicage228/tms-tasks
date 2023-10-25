package project.comm.userService.impl;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import project.comm.domain.JobTitle;
import project.comm.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        String name = rs.getString("name");
        String email = rs.getString("email");
        JobTitle jobTitle = JobTitle.valueOf(rs.getString("jobtitle"));
        return new User(email, jobTitle, name);
    }
}
