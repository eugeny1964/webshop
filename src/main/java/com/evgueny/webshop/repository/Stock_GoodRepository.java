package com.evgueny.webshop.repository;

import com.evgueny.webshop.db.key.Stock_Good_Key;
import com.evgueny.webshop.model.Stock_Good;
import org.springframework.data.repository.CrudRepository;

public interface Stock_GoodRepository extends CrudRepository<Stock_Good, Stock_Good_Key> {
}
