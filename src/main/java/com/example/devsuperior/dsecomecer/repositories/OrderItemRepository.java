package com.example.devsuperior.dsecomecer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devsuperior.dsecomecer.entities.OrderItem;
import com.example.devsuperior.dsecomecer.entities.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
