package com.example.LT_WEB.repository;

import com.example.LT_WEB.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository
        extends JpaRepository<Cart, Long> {
}