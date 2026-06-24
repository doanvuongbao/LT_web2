package com.example.LT_WEB.repository;

import com.example.LT_WEB.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
        extends JpaRepository<Order, Long> {
}