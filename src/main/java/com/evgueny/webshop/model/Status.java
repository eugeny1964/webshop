package com.evgueny.webshop.model;

import com.evgueny.webshop.model.enumType.StatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "status")
public class Status implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private StatusType type;
    @JsonIgnore
    @OneToMany(mappedBy = "status")
    List<Orders> ordersList;

    public Status() {
    }

    public Status(StatusType type) {
        this.type = type;
    }

    public Status(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusType getType() {
        return type;
    }

    public void setType(StatusType type) {
        this.type = type;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
