package com.example.devsuperior.dsecomecer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devsuperior.dsecomecer.Service.OrderService;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseOrderDTO;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseOrderDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }

}
