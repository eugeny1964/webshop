package com.evgueny.webshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stockroom")
public class StockRoom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long quantity;
    @OneToMany
    private List<Good> goodList;

    public StockRoom() { }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "StockRoom{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
