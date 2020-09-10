package com.evgueny.webshop.model;

import com.evgueny.webshop.model.enumType.UserRole;
import com.evgueny.webshop.model.enumType.UserStatusType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends User implements Serializable {

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    List<Orders> ordersList;

    public Client(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    public Client() {
    }

    public Client(@Size(min = 3, max = 15) String login, @Size(min = 3, max = 15) String password, LocalDateTime dateTime,
                  @NotNull String address, String phone, @Email String email, UserStatusType type) {
        super(login, password, dateTime, address, phone, email, type);
    }

    @Override
    public UserRole getRole() {
        return UserRole.USER;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }
}
