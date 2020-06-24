package com.evgueny.webshop.model;

import javax.persistence.*;

@Entity
@Table(name = "order_good")
public class Order_Good {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Good good;
    private int count;

    public Order_Good() { }

    public Order_Good(Order order, Good good, int count) {
        this.order = order;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
