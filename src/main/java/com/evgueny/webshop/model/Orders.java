package com.evgueny.webshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "orders")
    private List<Order_Good> order_good;
    private String number;

    public Orders() {
    }

    public List<Order_Good> getOrder_good() {
        return order_good;
    }

    public void setOrder_good(List<Order_Good> order_good) {
        this.order_good = order_good;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Orders(Delivery delivery, Status status, Client client) {
        this.delivery = delivery;
        this.status = status;
        this.client = client;
    }

    public Orders(List<Order_Good> order_goods) {
        this.order_good = order_goods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", delivery=" + delivery +
                ", status=" + status +
                ", client=" + client +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Order_Good> getOrder_goods() {
        return order_good;
    }

    public void setOrder_goods(List<Order_Good> order_good) {
        this.order_good = order_good;
    }
}

