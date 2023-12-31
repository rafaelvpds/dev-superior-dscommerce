package com.example.devsuperior.dsecomecer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devsuperior.dsecomecer.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
