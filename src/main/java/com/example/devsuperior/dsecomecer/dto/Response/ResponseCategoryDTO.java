package com.example.devsuperior.dsecomecer.dto.Response;

import com.example.devsuperior.dsecomecer.dto.Request.RequestCategoryDTO;
import com.example.devsuperior.dsecomecer.entities.Category;

public class ResponseCategoryDTO {
    private Long id;
    private String name;

    public ResponseCategoryDTO() {
    }

    public ResponseCategoryDTO(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public ResponseCategoryDTO(Category entity) {
        id = entity.getId();
        name = entity.getName();

    }

    public ResponseCategoryDTO(RequestCategoryDTO request) {

        name = request.getName();

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}