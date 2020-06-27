package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Orders;
import org.springframework.data.repository.CrudRepository;


public interface OrdersRepository extends CrudRepository<Orders,Long> {
}
