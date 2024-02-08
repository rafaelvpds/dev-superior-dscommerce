package com.example.devsuperior.dsecomecer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.devsuperior.dsecomecer.Service.exceptions.FobidenException;
import com.example.devsuperior.dsecomecer.entities.User;

@Service
public class AuthService {
    @Autowired
    private UserService userService;

    public void validateSelfOrAdm(Long userId) {
        User me = userService.authenticated();
        if (!me.hasRole("ROLE_ADMIN") && !me.getId().equals(userId)) {
            throw new FobidenException("Access denied");
        }

    }
}
