package com.evgueny.webshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "delivery")
public class Delivery implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private Double price;

    @OneToMany(mappedBy = "delivery")
    List<Orders> orderlist;

    public Delivery(List<Orders> orderlist) {
        this.orderlist = orderlist;
    }

    public Delivery(String type, Double price) {
        this.type=type;
        this.price=price;
    }

    public List<Orders> getOrderlist() {
        return orderlist;
    }

    public void setOrderlist(List<Orders> orderlist) {
        this.orderlist = orderlist;
    }

    public Delivery() {
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id_delivery=" + id +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId_delivery() {
        return id;
    }

    public void setId_delivery(Long id_delivery) {
        this.id = id_delivery;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
