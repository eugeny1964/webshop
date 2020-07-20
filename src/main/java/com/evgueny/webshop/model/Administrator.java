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
@Table(name = "administrator")
public class Administrator extends User implements Serializable {

    public Administrator() {
    }

    public Administrator(@Size(min = 3, max = 15) String login, @Size(min = 3, max = 15) String password,
                         @NotNull String address, String phone, @Email String email) {
        super(login, password, address, phone, email);
    }
}
