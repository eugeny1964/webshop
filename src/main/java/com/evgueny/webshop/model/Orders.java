package com.evgueny.webshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Delivery> deliveryList;

    @OneToMany
    private List<Status> statusList;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToMany(mappedBy = "ordersList")
    private List<Good> goodListOrder;

    public Orders(List<Good> goodListOrder) {
        this.goodListOrder = goodListOrder;
    }

    public List<Good> getGoodListOrder() {
        return goodListOrder;
    }

    public void setGoodListOrder(List<Good> goodListOrder) {
        this.goodListOrder = goodListOrder;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", client=" + client +
                '}';
    }

    public Orders(List<Delivery> deliveryList, List<Status> statusList, Client client) {
        this.deliveryList = deliveryList;
        this.statusList = statusList;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Delivery> getDeliveryList() {
        return deliveryList;
    }

    public void setDeliveryList(List<Delivery> deliveryList) {
        this.deliveryList = deliveryList;
    }

    public List<Status> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Status> statusList) {
        this.statusList = statusList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
