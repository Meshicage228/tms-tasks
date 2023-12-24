package com.example.lesson48springsecuritydb.exception.description;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsernameExceptionDescription {
    private String message;
}
