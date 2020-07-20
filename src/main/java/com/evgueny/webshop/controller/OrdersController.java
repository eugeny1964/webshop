package com.evgueny.webshop.controller;

import com.evgueny.webshop.model.*;
import com.evgueny.webshop.repository.Order_GoodRepository;
import com.evgueny.webshop.service.Order_GoodService;
import com.evgueny.webshop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private Order_GoodService order_goodService;

    @GetMapping
    public ResponseEntity<Object> getAllOrId(@Param(value = "id") Long id) {
        if (id == null) {
            return ResponseEntity.ok(ordersService.getAll());
        }
        return ResponseEntity.ok(ordersService.getById(id));
    }

    @GetMapping("/{id}")
    public Orders getById(@PathVariable Long id) {
        return ordersService.getById(id);
    }

    //Создание заказа(пустого)
    @PostMapping
    public Orders add( ) {
        Orders orders=new Orders();
        ordersService.addOrders(orders);
        return orders;
    }

    @DeleteMapping("/{id}")
    public Orders delete(@PathVariable Long id){
        System.out.println();
       return ordersService.deleteOrderById(id);
    }

    //Добавление товаров
    @PutMapping
    public Order_Good update(@RequestBody Order_Good order_good){
  //      Orders orders=ordersService.getById(order_good.getOrders_id());
       return order_goodService.add(order_good);
    }
}
