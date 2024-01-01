package com.example.devsuperior.dsecomecer.dto.Response;

import com.example.devsuperior.dsecomecer.entities.Product;

public class ResponseProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    public ResponseProductDTO() {
    }

    public ResponseProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ResponseProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
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

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
