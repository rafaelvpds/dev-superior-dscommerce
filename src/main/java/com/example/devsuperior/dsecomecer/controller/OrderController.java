package com.example.devsuperior.dsecomecer.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.devsuperior.dsecomecer.Service.OrderService;
import com.example.devsuperior.dsecomecer.dto.Request.RequestOrderDTO;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseOrderDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    @Autowired
    private OrderService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseOrderDTO> findById(@PathVariable Long id) {

        return ResponseEntity.ok(service.findById(id));
    }

    @PreAuthorize("hasRole('ROLE_CLIENT')")
    @PostMapping
    public ResponseEntity<ResponseOrderDTO> insertProduct(@Valid @RequestBody RequestOrderDTO dto) {
        ResponseOrderDTO ordertDTO = new ResponseOrderDTO(dto);
        ordertDTO = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(ordertDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(ordertDTO);
    }
}
