package com.example.LT_WEB.repository;

import com.example.LT_WEB.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<Product, Long> {
                
}