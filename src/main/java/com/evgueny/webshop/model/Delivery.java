package com.evgueny.webshop.model;

import com.evgueny.webshop.model.enumType.DeliveryType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "delivery")
public class Delivery implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private DeliveryType type;
    @NotNull
    private Double price;
    @JsonIgnore
    @OneToMany(mappedBy = "delivery")
    List<Orders> orderlist;

    public Delivery() {
    }

    public Delivery(DeliveryType type, Double price) {
        this.type = type;
        this.price = price;
    }

    public Delivery(List<Orders> orderlist) {
        this.orderlist = orderlist;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DeliveryType getType() {
        return type;
    }

    public void setType(DeliveryType type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Orders> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List<Orders> orderlist) {
        this.orderlist = orderlist;
    }
}
