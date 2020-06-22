package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Good;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface GoodRepository extends CrudRepository<Good,Long> {
    Good getAllByName(String name);
}
