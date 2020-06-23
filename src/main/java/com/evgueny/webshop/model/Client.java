package com.evgueny.webshop.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;
    private String phon;
    private String email;

    @OneToMany(mappedBy = "client")
    List<Orders> ordersList;

    List<Good> seach(Good good) { return null; }
    List<Good> addToCart(Good good) { return null; }
    void buy(List<Good> list) { }
    void quit() { }
    void pay() { }

    public Client(String name, String address, String phon,String email) {
        this.name = name;
        this.address = address;
        this.phon = phon;
        this.email=email;
    }
    public Client() {
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phon='" + phon + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Long getId_client() {
        return id;
    }

    public void setId_client(Long id_client) {
        this.id = id_client;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhon() {
        return phon;
    }

    public void setPhon(String phon) {
        this.phon = phon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
