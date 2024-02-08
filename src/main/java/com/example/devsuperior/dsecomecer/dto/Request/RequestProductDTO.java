package com.example.devsuperior.dsecomecer.dto.Request;

import java.util.ArrayList;
import java.util.List;

import com.example.devsuperior.dsecomecer.dto.Response.ResponseCategoryDTO;
import com.example.devsuperior.dsecomecer.entities.Category;
import com.example.devsuperior.dsecomecer.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class RequestProductDTO {
    private Long id;

    @NotBlank(message = "Campo requerido")
    @Size(min = 3, max = 80, message = "Nome precisa ter de 3 a 80 caracteres")
    private String name;

    @Size(min = 10, message = "descrição precisar ter no min 10 caracteres")
    @NotBlank(message = "Campo requerido")
    private String description;

    private String imgUrl;

    @NotEmpty(message = "Deve conter pelo menos uma categoria")
    private List<ResponseCategoryDTO> categories = new ArrayList<>();

    @Positive(message = "O preço deve ser positivos")
    private Double price;

    public RequestProductDTO() {
    }

    public RequestProductDTO(Long id, String name, String description, String imgUrl,
            List<ResponseCategoryDTO> categories,
            Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.categories = categories;
        this.price = price;
        this.categories = categories;
    }

    public RequestProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        imgUrl = entity.getImgUrl();
        price = entity.getPrice();
        for (Category cat : entity.getCategories()) {
            categories.add(new ResponseCategoryDTO(cat));
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Double getPrice() {
        return price;
    }

    public List<ResponseCategoryDTO> getCategories() {
        return categories;
    }

}
