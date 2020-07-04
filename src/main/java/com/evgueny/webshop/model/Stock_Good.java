package com.evgueny.webshop.model;
import com.evgueny.webshop.db.key.Stock_good_key;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stock_good")
@IdClass(value = Stock_good_key.class)
public class Stock_Good implements Serializable {
    @Id
    private Long stock_id;

    @Id
    private Long good_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stock_id",referencedColumnName = "id",insertable = false,updatable = false)
    private StockRoom stockroom;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Good good;
    private int count;

    public Stock_Good() { }

    public Stock_Good(Long stock_id, Long good_id, int count) {
        this.stock_id = stock_id;
        this.good_id = good_id;
        this.count = count;
    }

    public Stock_Good(StockRoom stockroom, Good good) {
        this.stockroom = stockroom;
        this.good = good;
    }

    @Override
    public String toString() {
        return "Stock_Good{" +
                "stock_id=" + stock_id +
                ", good_id=" + good_id +
                ", stockroom=" + stockroom +
                ", good=" + good +
                ", count=" + count +
                '}';
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

    public StockRoom getStockroom() {
        return stockroom;
    }

    public void setStockroom(StockRoom stockroom) {
        this.stockroom = stockroom;
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
