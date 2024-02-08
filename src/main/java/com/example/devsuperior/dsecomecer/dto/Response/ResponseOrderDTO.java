package com.example.devsuperior.dsecomecer.dto.Response;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.example.devsuperior.dsecomecer.dto.Request.RequestClientDTO;
import com.example.devsuperior.dsecomecer.dto.Request.RequestOrderItemDTO;
import com.example.devsuperior.dsecomecer.dto.Request.RequestPaymentDTO;
import com.example.devsuperior.dsecomecer.entities.Order;
import com.example.devsuperior.dsecomecer.entities.OrderItem;
import com.example.devsuperior.dsecomecer.entities.OrderStatus;

public class ResponseOrderDTO {
    private Long id;
    private Instant moment;
    private OrderStatus status;
    private RequestClientDTO client;
    private RequestPaymentDTO payment;
    private List<RequestOrderItemDTO> items = new ArrayList<>();

    public ResponseOrderDTO() {
    }

    public ResponseOrderDTO(Long id, Instant moment, OrderStatus status, RequestClientDTO client,
            RequestPaymentDTO payment) {
        this.id = id;
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.payment = payment;
    }

    public ResponseOrderDTO(Order entity) {
        id = entity.getId();
        moment = entity.getMoment();
        status = entity.getStatus();
        client = new RequestClientDTO(entity.getClient());
        payment = (entity.getPayment() == null) ? null
                : new RequestPaymentDTO(entity.getPayment());
        for (OrderItem item : entity.getItems()) {
            RequestOrderItemDTO itemDto = new RequestOrderItemDTO(item);
            items.add(itemDto);
        }
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public RequestClientDTO getClient() {
        return client;
    }

    public RequestPaymentDTO getPayment() {
        return payment;
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
