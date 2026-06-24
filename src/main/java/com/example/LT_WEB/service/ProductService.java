package com.example.LT_WEB.service;

import com.example.LT_WEB.entity.Product;
import com.example.LT_WEB.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product product) {

        Product old = repository.findById(id)
                .orElseThrow();

        old.setName(product.getName());
        old.setBrand(product.getBrand());
        old.setPrice(product.getPrice());
        old.setQuantity(product.getQuantity());
        old.setImage(product.getImage());
        old.setDescription(product.getDescription());

        return repository.save(old);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}