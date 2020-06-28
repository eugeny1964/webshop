package com.evgueny.webshop.model;

import com.evgueny.webshop.db.key.Order_Good_Key;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "order_good")
@IdClass(Order_Good_Key.class)
public class Order_Good implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "orders_id")
    private Orders orders;
    @Id
    @ManyToOne
    @JoinColumn(name = "good_id")
    private Good goodd;

    private Long count;

    public Order_Good() { }

    public Order_Good(Orders orders, Good good) {
        this.orders = orders;
        this.goodd = good;
    }

    public Order_Good(Orders orders, Good good, Long count) {
        this.orders = orders;
        this.goodd = good;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Order_Good{" +
                "orders=" + orders +
                ", good=" + goodd +
                ", count=" + count +
                '}';
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Good getGood() {
        return goodd;
    }

    public void setGood(Good good) {
        this.goodd = good;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
