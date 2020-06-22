package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Delivery;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface DeliveryRepository extends CrudRepository<Delivery,Long> {
}
