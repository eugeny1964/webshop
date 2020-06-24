package com.evgueny.webshop.model;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue
    private Long id;
    private String type;

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
