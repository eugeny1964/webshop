package com.evgueny.webshop.db.key;
import java.io.Serializable;
import java.util.Objects;

public class Order_Good_Key implements Serializable {
    private Long orders_id;
    private Long good_id;

    public Order_Good_Key() {
    }

    public Order_Good_Key(Long orders_id, Long good_id) {
        this.orders_id = orders_id;
        this.good_id = good_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order_Good_Key)) return false;
        Order_Good_Key that = (Order_Good_Key) o;
        return orders_id.equals(that.orders_id) &&
                good_id.equals(that.good_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders_id, good_id);
    }

    public Long getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(Long orders_id) {
        this.orders_id = orders_id;
    }

    public Long getGood_id() {
        return good_id;
    }

    public void setGood_id(Long good_id) {
        this.good_id = good_id;
    }
}
