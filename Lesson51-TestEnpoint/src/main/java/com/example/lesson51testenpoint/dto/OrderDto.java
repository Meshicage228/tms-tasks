package com.example.lesson51testenpoint.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class OrderDto {
    Integer id;
    String title;
    Integer money;
}
