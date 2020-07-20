package com.evgueny.webshop.model;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "oldclient")
public class OldClient extends User implements Serializable {

    private Long discount;

    @OneToMany(mappedBy = "client")
    List<Orders> ordersList;

    public OldClient() {
    }

    public OldClient(@Size(min = 3, max = 15) String login, @Size(min = 3, max = 15) String password,
                     @NotNull String address, String phone, @Email String email,Long discount) {
        super(login, password, address, phone, email);
        this.discount=discount;
    }

    @Override
    public String toString() {
        return "OldClient{" +
                "discount=" + discount +
                ", ordersList=" + ordersList +
                '}';
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
