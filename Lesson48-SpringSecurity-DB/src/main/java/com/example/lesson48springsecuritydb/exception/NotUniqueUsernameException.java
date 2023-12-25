package com.example.lesson48springsecuritydb.exception;

import lombok.Getter;

@Getter
public class NotUniqueUsernameException extends RuntimeException{
    private final String message;

    public NotUniqueUsernameException(String message) {
        this.message = message;
    }
}
