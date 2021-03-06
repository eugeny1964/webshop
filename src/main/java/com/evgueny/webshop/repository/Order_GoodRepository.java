package com.evgueny.webshop.repository;

import com.evgueny.webshop.db.key.Order_Good_Key;
import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.model.Order_Good;
import org.springframework.data.repository.CrudRepository;


public interface Order_GoodRepository extends CrudRepository<Order_Good, Long> {
    Order_Good findByCount(Long counte);
}
