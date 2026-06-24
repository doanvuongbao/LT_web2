package com.example.LT_WEB.service;

import com.example.LT_WEB.entity.Cart;
import com.example.LT_WEB.repository.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository repository;

    public CartService(CartRepository repository) {
        this.repository = repository;
    }

    public Cart getCart(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Cart save(Cart cart) {
        return repository.save(cart);
    }
}