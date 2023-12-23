package com.example.store.exception.details;

import lombok.Builder;

@Builder
public class BadWordExceptionDetails {
    private String message;
    private Integer code;
}
