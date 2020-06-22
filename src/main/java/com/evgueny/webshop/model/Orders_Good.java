package com.evgueny.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders_good")
public class Orders_Good {
    @Id
    @GeneratedValue
    private Long id;
    private Long id_good;
    private Long id_orders;
    private Long count;

    public Orders_Good(Long id_good, Long id_orders, Long count) {
        this.id_good = id_good;
        this.id_orders = id_orders;
        this.count = count;
    }

    public Orders_Good() {
    }

    @Override
    public String toString() {
        return "Orders_Good{" +
                "id=" + id +
                ", id_good=" + id_good +
                ", id_orders=" + id_orders +
                ", count=" + count +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_good() {
        return id_good;
    }

    public void setId_good(Long id_good) {
        this.id_good = id_good;
    }

    public Long getId_orders() {
        return id_orders;
    }

    public void setId_orders(Long id_orders) {
        this.id_orders = id_orders;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
