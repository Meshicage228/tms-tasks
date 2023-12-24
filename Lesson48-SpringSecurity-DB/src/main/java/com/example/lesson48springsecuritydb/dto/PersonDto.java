package com.example.lesson48springsecuritydb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PersonDto {
    private Integer id;
    private String username;
    private String pass;
    private String perm;

}
