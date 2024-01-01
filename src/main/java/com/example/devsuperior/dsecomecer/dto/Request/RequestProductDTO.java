package com.example.devsuperior.dsecomecer.dto.Request;

public class RequestProductDTO {
    private String name;
    private String description;
    private String imgUrl;
    private Double price;

    public RequestProductDTO() {
    }

    public RequestProductDTO(String name, String description, String imgUrl, Double price) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
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
