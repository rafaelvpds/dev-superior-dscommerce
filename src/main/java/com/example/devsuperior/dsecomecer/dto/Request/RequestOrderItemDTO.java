package com.example.devsuperior.dsecomecer.dto.Request;

import com.example.devsuperior.dsecomecer.entities.OrderItem;

public class RequestOrderItemDTO {
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;
    private String img;

    public RequestOrderItemDTO() {
    }

    public RequestOrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        img = entity.getProduct().getImgUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getImg() {
        return img;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

}
