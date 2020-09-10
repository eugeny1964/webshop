package com.evgueny.webshop.model;

import com.evgueny.webshop.model.enumType.UserRole;
import com.evgueny.webshop.model.enumType.UserStatusType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "administrator")
public class Administrator extends User implements Serializable {

    public Administrator() {
    }

    public Administrator(@Size(min = 3, max = 15) String login, @Size(min = 3, max = 15) String password, LocalDateTime dateTime,
                         @NotNull String address, String phone, @Email String email, UserStatusType type) {
        super(login, password, dateTime, address, phone, email, type);
    }

    @Override
    public UserRole getRole() {
        return UserRole.ADMIN;
    }
}
