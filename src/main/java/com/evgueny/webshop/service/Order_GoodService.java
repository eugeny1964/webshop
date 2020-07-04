package com.evgueny.webshop.service;

import com.evgueny.webshop.model.Order_Good;
import com.evgueny.webshop.repository.Order_GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class Order_GoodService {
    @Autowired
    Order_GoodRepository order_goodRepository;

    @Transactional
    public Order_Good getOrder_GoodByCount(Long count) {
        return order_goodRepository.findByCount(count);
    }
}
