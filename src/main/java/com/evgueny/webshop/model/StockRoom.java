package com.evgueny.webshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stockroom")
public class StockRoom implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String number;

    @OneToMany(mappedBy = "stockroom")
    private List<Stock_Good> stock_goods;


    public StockRoom() {
    }

    public StockRoom(String number) {
        this.number = number;
    }

    public StockRoom(String number, List<Stock_Good> stock_goods) {
        this.number = number;
        this.stock_goods = stock_goods;
    }

    @Override
    public String toString() {
        return "StockRoom{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<Stock_Good> getStock_goods() {
        return stock_goods;
    }

    public void setStock_goods(List<Stock_Good> stock_goods) {
        this.stock_goods = stock_goods;
    }
}
