package com.evgueny.webshop.model;
import javax.persistence.*;


@Entity
@Table(name = "stock_good")
public class Stock_Good {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "stock_id" )
    private StockRoom stockRoom;
    @ManyToOne
    @JoinColumn(name = "good_id" )
    private Good good;
    private int count;

    public Stock_Good() {
    }

    public Stock_Good(StockRoom stockRoom, Good good, int count) {
        this.stockRoom = stockRoom;
        this.good = good;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Stock_Good{" +
                "id=" + id +
                ", stockRoom=" + stockRoom +
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
