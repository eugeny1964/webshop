package com.evgueny.webshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "good")
public class Good implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @Size(min = 1, max = 100)
    private String name;
    @NotNull(message = "Цена не может быть пустой")
    @Positive
    @Max(value = 100000, message = "Слишком высо")
    private Double price;

    @OneToMany(mappedBy = "good",cascade =CascadeType.ALL)
    @JsonIgnore
    private List<Order_Good> order_good;

    @JsonIgnore
    @OneToMany(mappedBy = "good", cascade = CascadeType.ALL)
    private List<Stock_Good> stock_goods;

    public Good() {
    }

    public Good(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Good(List<Order_Good> order_good, List<Stock_Good> stock_goods) {
        this.order_good = order_good;
        this.stock_goods = stock_goods;
    }

    public Good(String name, Double price, List<Stock_Good> stock_goods) {
        this.name = name;
        this.price = price;
        this.stock_goods = stock_goods;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public List<Order_Good> getOrder_good() {
        return order_good;
    }

    public void setOrder_good(List<Order_Good> order_good) {
        this.order_good = order_good;
    }

    public List<Stock_Good> getStock_goods() {
        return stock_goods;
    }

    public void setStock_goods(List<Stock_Good> stock_goods) {
        this.stock_goods = stock_goods;
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


