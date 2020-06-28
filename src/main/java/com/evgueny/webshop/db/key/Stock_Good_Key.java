package com.evgueny.webshop.db.key;

import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.model.StockRoom;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;
public class Stock_Good_Key implements Serializable {

    private StockRoom stockRoom;
    private Good good;

    public Stock_Good_Key() {
    }

    public Stock_Good_Key(StockRoom stockRoom, Good good) {
        this.stockRoom = stockRoom;
        this.good = good;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stock_Good_Key)) return false;
        Stock_Good_Key that = (Stock_Good_Key) o;
        return Objects.equals(stockRoom, that.stockRoom) &&
                Objects.equals(good, that.good);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stockRoom, good);
    }

    public StockRoom getStockRoom() {
        return stockRoom;
    }

    public void setStockRoom(StockRoom stockRoom) {
        this.stockRoom = stockRoom;
    }

    public Good getGood() {
        return good;
    }

    public void setGood(Good good) {
        this.good = good;
    }
}
