package com.example.lesson49springsecuritytoken.dto;

import com.example.lesson49springsecuritytoken.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String password;
    private String phoneNumber;
    private String role;
}
