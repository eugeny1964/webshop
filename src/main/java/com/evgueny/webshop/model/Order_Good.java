package com.evgueny.webshop.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_good")
public class Order_Good implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Orders order;

    @ManyToOne
    private Good good;

    private int count;

    public Order_Good() { }

    public Order_Good(Orders orders, Good good, int count) {
        this.order = orders;
        this.good = good;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Order_Good{" +
                "id=" + id +
                ", order=" + order +
                ", good=" + good +
                ", count=" + count +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders orders) {
        this.order = orders;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
