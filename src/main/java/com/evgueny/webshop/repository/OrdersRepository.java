package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Order;
import org.springframework.data.repository.CrudRepository;


public interface OrdersRepository extends CrudRepository<Order,Long> {
}
