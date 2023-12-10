package com.example.store.config;


import com.example.store.exception.CarGetIdException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Logger;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@RequiredArgsConstructor
@Configuration
public class StoreConfiguration {
    private final ObjectMapper mapper;
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
    @Bean
    ErrorDecoder decoder() {
        return ((methodKey, response) -> {
            int status = response.status();
            if (status >= 400 && status < 500) {
                Response.Body body = response.body();
                try {
                    return mapper.readValue(body.asInputStream(), CarGetIdException.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return null;
        });
    }
}
