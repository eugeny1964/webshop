package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface UserRepositiry extends CrudRepository<User,Long> {
    List<User> findAllByDateTimeAfter(LocalDateTime localDateTime) ;
}
