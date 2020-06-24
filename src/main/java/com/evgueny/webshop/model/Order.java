package com.evgueny.webshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_delivery")
    private Delivery delivery;
    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @OneToMany(mappedBy = "order")
    private List<Order_Good> order_good;

    public Order() {
    }

    public Order(Delivery delivery, Status status, Client client, List<Order_Good> order_good) {
        this.delivery = delivery;
        this.status = status;
        this.client = client;
        this.order_good = order_good;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", delivery=" + delivery +
                ", status=" + status +
                ", client=" + client +
                ", order_good=" + order_good +
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

    public List<Order_Good> getOrder_good() {
        return order_good;
    }

    public void setOrder_good(List<Order_Good> order_good) {
        this.order_good = order_good;
    }
}
