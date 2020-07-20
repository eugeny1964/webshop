package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface OrdersRepository extends CrudRepository<Orders,Long> {
    }
