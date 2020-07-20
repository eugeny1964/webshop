package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositiry extends CrudRepository<User,Long> {
}
