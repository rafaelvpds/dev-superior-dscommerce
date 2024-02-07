package com.example.devsuperior.dsecomecer.dto.Request;

import com.example.devsuperior.dsecomecer.entities.Category;

public class RequestCategoryDTO {
    private Long id;
    private String name;

    public RequestCategoryDTO() {
    }

    public RequestCategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public RequestCategoryDTO(Category entity) {
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
