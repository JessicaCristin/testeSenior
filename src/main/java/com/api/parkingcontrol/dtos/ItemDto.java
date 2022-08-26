package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.model.OrderItensModel;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.UUID;

public class ItemDto {
    @NotBlank
    private UUID id;

    @NotBlank
    private Collection<OrderItensModel> orderItens;
    @NotBlank
    private String description;

    @NotBlank
    private double value;

    @NotBlank
    private char type;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Collection<OrderItensModel> getOrderItens() {
        return orderItens;
    }

    public void setOrderItens(Collection<OrderItensModel> orderItens) {
        this.orderItens = orderItens;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

}
