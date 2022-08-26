package com.api.parkingcontrol.dtos;

import com.api.parkingcontrol.model.ItemModel;
import com.api.parkingcontrol.model.OrderModel;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class OrderItensDto {
    @NotBlank
    private UUID id;

    @NotBlank
    private OrderModel order;

    @NotBlank
    private ItemModel item;

    @NotBlank
    private double quantity;

    @NotBlank
    private double totalValue;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public OrderModel getOrder() {
        return order;
    }

    public void setOrder(OrderModel order) {
        this.order = order;
    }

    public ItemModel getItem() {
        return item;
    }

    public void setItem(ItemModel item) {
        this.item = item;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }
}
