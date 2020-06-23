package com.evgueny.webshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "good")
public class Good implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Double price;

    @ManyToMany
    @JoinTable(name = "orders_good",
            joinColumns = @JoinColumn(name = "id_client"),
            inverseJoinColumns = @JoinColumn(name = "id_orders")
    )
    private List<Orders> ordersList;

    public Good(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Good(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Good() {
    }

    @Override
    public String toString() {
        return "Good{" +
                "id_good=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id_good) {
        this.id = id_good;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}


