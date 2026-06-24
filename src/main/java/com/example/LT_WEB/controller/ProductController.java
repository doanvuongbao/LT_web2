package com.example.LT_WEB.controller;

import com.example.LT_WEB.entity.Product;
import com.example.LT_WEB.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

    private final ProductService productService;
    
    public ProductController(
            ProductService productService) {

        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(
            @PathVariable Long id) {

        return productService.getProductById(id);
    }

    @PostMapping
    public Product create(
            @RequestBody Product product) {

        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(
            @PathVariable Long id,
            @RequestBody Product product) {

        return productService.update(id, product);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id) {

        productService.delete(id);

        return "Deleted";
    }
}