package com.evgueny.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    private String type;
    private Double price;

    public Delivery(String type,Double price) {
        this.type=type;
        this.price=price;
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
