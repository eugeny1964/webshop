package com.evgueny.webshop.repository;

import com.evgueny.webshop.db.key.Stock_good_key;
import com.evgueny.webshop.model.Stock_Good;
import org.springframework.data.repository.CrudRepository;

public interface Stock_GoodRepository extends CrudRepository<Stock_Good, Stock_good_key> {
}
