package com.example.devsuperior.dsecomecer.dto.Request;

public class RequestProductDTO {
    private Long id;
    private String name;
    private String description;
    private String imgUrl;
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
