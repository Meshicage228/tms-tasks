package com.example.store.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CarGetIdException extends RuntimeException {
    private final String serviceName;
    @JsonProperty("message")
    private final String exceptionMessage;
    private final Integer code;

    public CarGetIdException(String serviceName, String message, Integer code) {
        this.serviceName = serviceName;
        this.exceptionMessage = message;
        this.code = code;
    }
}
