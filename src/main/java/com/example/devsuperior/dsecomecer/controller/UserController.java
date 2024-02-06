package com.example.devsuperior.dsecomecer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.devsuperior.dsecomecer.Service.UserService;
import com.example.devsuperior.dsecomecer.dto.Response.ResponseUserDTO;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService service;

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
    @GetMapping(value = "/me")
    public ResponseEntity<ResponseUserDTO> getMe() {

        return ResponseEntity.ok(service.getMe());
    }

}
