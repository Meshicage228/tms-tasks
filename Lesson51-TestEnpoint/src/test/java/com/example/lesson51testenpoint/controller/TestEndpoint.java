package com.example.lesson51testenpoint.controller;

import com.example.lesson51testenpoint.dto.OrderDto;
import com.example.lesson51testenpoint.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@WebMvcTest(AppController.class)
class TestEndpoint {
    @MockBean
    OrderService service;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;
    @Test
    void saveOrder() throws Exception {
        // Given
        OrderDto order = OrderDto.builder()
                .title("cars")
                .money(24423)
                .build();

        Mockito.when(service.save(order)).thenReturn(order);
        String json = mapper.writeValueAsString(order);
        // When
        mockMvc.perform(post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title", CoreMatchers.is(order.getTitle())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.money", CoreMatchers.is(order.getMoney())));



    }
}