package com.example.devsuperior.dsecomecer.dto.Request;

import java.util.ArrayList;
import java.util.List;

import com.example.devsuperior.dsecomecer.entities.Order;
import com.example.devsuperior.dsecomecer.entities.OrderItem;

import jakarta.validation.constraints.NotEmpty;

public class RequestOrderDTO {
    private Long id;
    @NotEmpty(message = "Deve conter pelo menos um item")
    private List<RequestOrderItemDTO> items = new ArrayList<>();

    public RequestOrderDTO() {
    }

    public RequestOrderDTO(Long id) {
        this.id = id;

    }

    public RequestOrderDTO(Order entity) {
        id = entity.getId();
        for (OrderItem item : entity.getItems()) {
            RequestOrderItemDTO itemDto = new RequestOrderItemDTO(item);
            items.add(itemDto);
        }
    }

    public Long getId() {
        return id;
    }

    public List<RequestOrderItemDTO> getItems() {
        return items;
    }

    public Double getTotal() {
        double sum = 0.0;

        for (RequestOrderItemDTO item : items) {
            sum = sum + item.getSubTotal();
        }
        return sum;
    }

}
