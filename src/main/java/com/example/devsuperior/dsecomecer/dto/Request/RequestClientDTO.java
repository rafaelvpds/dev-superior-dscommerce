package com.example.devsuperior.dsecomecer.dto.Request;

import com.example.devsuperior.dsecomecer.entities.User;

public class RequestClientDTO {
    private Long id;
    private String name;

    public RequestClientDTO() {
    }

    public RequestClientDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public RequestClientDTO(User entity) {
        id = entity.getId();
        name = entity.getName();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
