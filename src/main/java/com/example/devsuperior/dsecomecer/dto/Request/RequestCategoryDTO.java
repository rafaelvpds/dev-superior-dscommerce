package com.example.devsuperior.dsecomecer.dto.Request;

import com.example.devsuperior.dsecomecer.entities.Category;

public class RequestCategoryDTO {
    private String name;

    public RequestCategoryDTO() {
    }

    public RequestCategoryDTO(Long id, String name) {
        this.name = name;

    }

    public RequestCategoryDTO(Category entity) {
        name = entity.getName();
    }

    public String getName() {
        return name;
    }

}
