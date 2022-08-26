package com.api.parkingcontrol.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name="item")
public class ItemModel implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private Collection<OrderItensModel> orderItens;

    @Column(nullable = false, length = 60)
    private String description;

    @Column(nullable = false)
    private double value;
    @Column(nullable = false, length = 1)
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
