package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Orders_Good;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface Order_GoodRepository extends CrudRepository<Orders_Good,Long> {
}
