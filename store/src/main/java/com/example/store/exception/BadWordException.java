package com.example.store.exception;


import lombok.Getter;

@Getter
public class BadWordException extends RuntimeException{
    private final String message;
    private final Integer code;

    public BadWordException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
