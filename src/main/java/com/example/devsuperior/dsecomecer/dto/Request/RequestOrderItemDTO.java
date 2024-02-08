package com.example.devsuperior.dsecomecer.dto.Request;

import com.example.devsuperior.dsecomecer.entities.OrderItem;

public class RequestOrderItemDTO {
    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;

    public RequestOrderItemDTO() {
    }

    public RequestOrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
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

    public Double getSubTotal() {
        return price * quantity;
    }

}
