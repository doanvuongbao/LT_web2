package com.example.LT_WEB.controller;

import com.example.LT_WEB.entity.Order;
import com.example.LT_WEB.repository.OrderRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {

    private final OrderRepository repository;

    public OrderController(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Order> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return repository.save(order);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElse(null);
    }
}