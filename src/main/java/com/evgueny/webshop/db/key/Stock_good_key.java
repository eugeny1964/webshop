package com.evgueny.webshop.db.key;
import java.io.Serializable;
import java.util.Objects;

public class Stock_good_key implements Serializable {

    private Long stock_id;
    private Long good_id;

    public Stock_good_key() {
    }

    public Stock_good_key(Long stock_id, Long good_id) {
        this.stock_id = stock_id;
        this.good_id = good_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock_good_key)) return false;
        Stock_good_key that = (Stock_good_key) o;
        return stock_id.equals(that.stock_id) &&
                good_id.equals(that.good_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stock_id, good_id);
    }

    public Long getStock_id() {
        return stock_id;
    }

    public void setStock_id(Long stock_id) {
        this.stock_id = stock_id;
    }

    public Long getGood_id() {
        return good_id;
    }

    public void setGood_id(Long good_id) {
        this.good_id = good_id;
    }
}
