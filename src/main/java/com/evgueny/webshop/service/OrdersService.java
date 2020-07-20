package com.evgueny.webshop.service;

import com.evgueny.webshop.exception.ResourseNotFoundException;
import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.model.Orders;
import com.evgueny.webshop.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;

    public List<Orders> getAll() {
        return (List<Orders>) ordersRepository.findAll();
    }

    public Orders getById(Long id) {
        System.out.println();
        return ordersRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Заказ", id));
    }

    public Orders addOrders(Orders orders) {
        System.out.println();
        return ordersRepository.save(orders);
    }


    public Orders deleteOrderById(Long id) {
        Orders orders = ordersRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Заказ", id));
        ordersRepository.deleteById(id);
        return orders;
    }

    @Transactional
    public Orders update(Long id, Orders orders) {
        Orders orders1 = ordersRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Заказ", id));
        orders1.setStatus(orders1.getStatus());
        orders1.setClient(orders1.getClient());
        orders1.setDelivery(orders1.getDelivery());
        orders1.setNumber(orders1.getNumber());
        return orders1;
    }
}
