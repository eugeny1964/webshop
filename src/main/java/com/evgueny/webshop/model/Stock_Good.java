package com.evgueny.webshop.model;
import com.evgueny.webshop.db.key.Stock_Good_Key;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "stock_good")
@IdClass(Stock_Good_Key.class)
public class Stock_Good implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "stock_id" )
    private StockRoom stockRoom;
    @Id
    @ManyToOne
    @JoinColumn(name = "good_id" )
    private Good good;
    private int count;

    public Stock_Good() {
    }

    public Stock_Good(Stock_Good_Key stock_good_key, int count) {
        this.stockRoom = stock_good_key.getStockRoom();
        this.good = stock_good_key.getGood();
        this.count = count;
    }
    public Stock_Good(StockRoom stockRoom, Good good) {
        this.stockRoom = stockRoom;
        this.good = good;
    }
    @Override
    public String toString() {
        return "Stock_Good{" +
                ", stockRoom=" + stockRoom +
                ", good=" + good +
                ", count=" + count +
                '}';
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
