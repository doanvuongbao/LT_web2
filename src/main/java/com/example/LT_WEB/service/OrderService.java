package com.example.LT_WEB.service;

import com.example.LT_WEB.entity.*;
import com.example.LT_WEB.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(Order order) {

        order.setCreatedAt(LocalDateTime.now());

        order.setStatus("PENDING");

        return orderRepository.save(order);
    }
}