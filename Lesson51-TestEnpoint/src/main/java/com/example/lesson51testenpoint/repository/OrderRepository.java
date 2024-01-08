package com.example.lesson51testenpoint.repository;

import com.example.lesson51testenpoint.dto.OrderDto;
import com.example.lesson51testenpoint.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
}
