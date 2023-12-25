package com.example.store.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public GroupedOpenApi storeGroup(){
        String[] paths = {"/store/cars/**"};

        return GroupedOpenApi.builder()
                .group("il-carStore-controller")
                .pathsToMatch(paths)
                .build();
    }
}
