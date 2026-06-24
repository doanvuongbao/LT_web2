package com.example.LT_WEB.controller;

import com.example.LT_WEB.entity.CartItem;
import com.example.LT_WEB.repository.CartItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    private final CartItemRepository repository;

    public CartController(
            CartItemRepository repository) {

        this.repository = repository;
    }

    @GetMapping
    public List<CartItem> getAll() {
        return repository.findAll();
    }

    @PostMapping("/add")
    public CartItem add(
            @RequestBody CartItem item) {

        return repository.save(item);
    }

    @DeleteMapping("/{id}")
    public void remove(
            @PathVariable Long id) {

        repository.deleteById(id);
    }
}