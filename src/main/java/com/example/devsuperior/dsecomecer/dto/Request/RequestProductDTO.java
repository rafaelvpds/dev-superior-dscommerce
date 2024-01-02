package com.example.devsuperior.dsecomecer.dto.Request;

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

    @Positive(message = "O preço deve ser positivos")

    private Double price;

    public RequestProductDTO() {
    }

    public RequestProductDTO(Long id, String name, String description, String imgUrl, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
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

}
