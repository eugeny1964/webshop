package com.evgueny.webshop.db.key;

import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.model.Orders;
import java.io.Serializable;
import java.util.Objects;

public class Order_Good_Key implements Serializable {
    private Orders orders;
    private Good goodd;

    public Order_Good_Key() {
    }

    public Order_Good_Key(Orders orders, Good good) {
        this.orders = orders;
        this.goodd = good;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order_Good_Key)) return false;
        Order_Good_Key that = (Order_Good_Key) o;
        return Objects.equals(orders, that.orders) &&
                Objects.equals(goodd, that.goodd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders, goodd);
    }

    public Orders getOrders() {
        return orders;
    }

    public Good getGood() {
        return goodd;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void setGood(Good good) {
        this.goodd = good;
    }
}
