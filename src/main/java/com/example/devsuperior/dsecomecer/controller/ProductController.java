package com.example.devsuperior.dsecomecer.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devsuperior.dsecomecer.entities.Product;
import com.example.devsuperior.dsecomecer.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String test() {
        Optional<Product> proOptional = productRepository.findById(1L);
        Product product = proOptional.get();
        return product.getName();
    }
}
