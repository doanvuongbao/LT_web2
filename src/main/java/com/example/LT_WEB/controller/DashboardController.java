package com.example.LT_WEB.controller;

import com.example.LT_WEB.repository.ProductRepository;
import com.example.LT_WEB.repository.UserRepository;
import com.example.LT_WEB.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public DashboardController(
            ProductRepository productRepository,
            UserRepository userRepository,
            OrderRepository orderRepository) {

        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public Map<String, Object> dashboard() {

        Map<String, Object> data = new HashMap<>();

        data.put("totalProducts", productRepository.count());
        data.put("totalUsers", userRepository.count());
        data.put("totalOrders", orderRepository.count());

        return data;
    }
}