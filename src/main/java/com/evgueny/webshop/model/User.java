package com.evgueny.webshop.model;

import com.evgueny.webshop.model.enumType.UserRole;
import com.evgueny.webshop.model.enumType.UserStatusType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 3,max = 15)
    private String login;
    private String password;

    @NotNull
    private String address;
    private String phone;
    @Email
    private String email;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateTime;
    @Enumerated(EnumType.STRING)
    private UserStatusType type;

    public User(@Size(min = 3, max = 15) String login, @Size(min = 3, max = 15)
            String password,LocalDateTime dateTime, @NotNull String address, String phone, @Email String email,UserStatusType type) {
        this.login = login;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dateTime=dateTime;
        this.type=type;
    }
    public User() { }

    abstract public UserRole getRole();

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", dateTime=" + dateTime +
                ", type=" + type +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UserStatusType getType() {
        return type;
    }

    public void setType(UserStatusType type) {
        this.type = type;
    }
}
