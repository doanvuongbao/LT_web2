package com.example.LT_WEB.repository;

import com.example.LT_WEB.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {
}