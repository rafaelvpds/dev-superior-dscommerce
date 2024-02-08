package com.example.devsuperior.dsecomecer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.devsuperior.dsecomecer.Service.exceptions.ResourceNotFoundExceptions;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseOrderDTO;
import com.example.devsuperior.dsecomecer.entities.Order;
import com.example.devsuperior.dsecomecer.repositories.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public ResponseOrderDTO findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("Order not found"));
        return new ResponseOrderDTO(order);
    }
}
