package com.evgueny.webshop.model;

import com.evgueny.webshop.db.key.Order_Good_Key;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Table(name = "order_good")
@IdClass(value = Order_Good_Key.class)
public class Order_Good implements Serializable {
    @Id
    private Long orders_id;

    @Id
    private Long good_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orders_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Orders orders;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "good_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Good good;
    @NotNull
    @Positive
    private Long count;

    public Order_Good() {
    }

    public Order_Good(Long good_id, Long orders_id, Long count) {
        this.good_id = good_id;
        this.orders_id = orders_id;
        this.count = count;
    }

    public Order_Good(Orders orders, Good good) {
        this.orders = orders;
        this.good = good;
    }

    @Override
    public String toString() {
        return "Order_Good{" +
                "good_id=" + good_id +
                ", orders_id=" + orders_id +
/*                ", orders=" + orders +
                ", good=" + good +*/
                ", count=" + count +
                '}';
    }

    public Long getGood_id() {
        return good_id;
    }

    public void setGood_id(Long good_id) {
        this.good_id = good_id;
    }

    public Long getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(Long orders_id) {
        this.orders_id = orders_id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
