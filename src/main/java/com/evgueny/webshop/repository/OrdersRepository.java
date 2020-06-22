package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Orders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface OrdersRepository extends CrudRepository<Orders,Long> {
}
