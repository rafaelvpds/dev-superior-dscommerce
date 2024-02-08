package com.example.devsuperior.dsecomecer.dto.Response;

import com.example.devsuperior.dsecomecer.dto.Request.RequestProductDTO;
import com.example.devsuperior.dsecomecer.entities.Product;

public class ResponseProductMinDTO {
    private Long id;
    private String name;
    private Double price;
    private String imgUrl;

    public ResponseProductMinDTO() {
    }

    public ResponseProductMinDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ResponseProductMinDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }

    public ResponseProductMinDTO(RequestProductDTO request) {
        id = request.getId();
        name = request.getName();
        price = request.getPrice();
        imgUrl = request.getImgUrl();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

}
