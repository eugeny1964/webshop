package com.evgueny.webshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue
    private Long id;
    private Long id_delivery;
    private Long id_status;

    private Long id_client;

    public Orders(Long id_delivery, Long id_status, Long id_client) {
        this.id_delivery = id_delivery;
        this.id_status = id_status;
        this.id_client = id_client;
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", id_delivery=" + id_delivery +
                ", id_status=" + id_status +
                ", id_client=" + id_client +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_delivery() {
        return id_delivery;
    }

    public void setId_delivery(Long id_delivery) {
        this.id_delivery = id_delivery;
    }

    public Long getId_status() {
        return id_status;
    }

    public void setId_status(Long id_status) {
        this.id_status = id_status;
    }

    public Long getId_client() {
        return id_client;
    }

    public void setId_client(Long id_client) {
        this.id_client = id_client;
    }
}
