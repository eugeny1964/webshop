package com.evgueny.webshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "status")
public class Status implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String type;

    @OneToMany(mappedBy = "status")
    List<Orders> ordersList;

    public Status() {
    }

    public Status(String type) {
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
