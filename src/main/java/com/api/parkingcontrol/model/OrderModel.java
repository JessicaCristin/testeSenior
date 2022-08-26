package com.api.parkingcontrol.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name="tb_order")
public class OrderModel implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Collection<OrderItensModel> orderItens;

    @Column(nullable = false)
    private Integer number;

    @Column(nullable = false)
    private double percentualDiscount;

    @Column(nullable = false)
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

