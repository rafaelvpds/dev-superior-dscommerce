package com.example.devsuperior.dsecomecer.dto.Request;

import java.time.Instant;

import com.example.devsuperior.dsecomecer.entities.Payment;

public class RequestPaymentDTO {
    private Long id;
    private Instant moment;

    public RequestPaymentDTO() {
    }

    public RequestPaymentDTO(Long id, Instant moment) {
        this.id = id;
        this.moment = moment;
    }

    public RequestPaymentDTO(Payment entity) {
        id = entity.getId();
        moment = entity.getMoment();
    }

    public Long getId() {
        return id;
    }

    public Instant getMoment() {
        return moment;
    }

}
