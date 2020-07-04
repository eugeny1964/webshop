package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Good;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface GoodRepository extends CrudRepository<Good,Long> {
    Good getAllById(Long id);
    List<Good> getAllByPrice(Double price);
    List<Good> findAllByName(String name);
}
