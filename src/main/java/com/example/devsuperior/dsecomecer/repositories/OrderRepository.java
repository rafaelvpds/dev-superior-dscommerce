package com.example.devsuperior.dsecomecer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devsuperior.dsecomecer.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
