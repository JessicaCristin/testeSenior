package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.model.OrderItensModel;

import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.UUID;

public class OrderDto {
    @NotBlank
    private UUID id;

    @NotBlank
    private Collection<OrderItensModel> orderItens;

    @NotBlank
    private Integer number;

    @NotBlank
    private double percentualDiscount;

    @NotBlank
    private double totalValue;

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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getPercentualDiscount() {
        return percentualDiscount;
    }

    public void setPercentualDiscount(double percentualDiscount) {
        this.percentualDiscount = percentualDiscount;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

}
