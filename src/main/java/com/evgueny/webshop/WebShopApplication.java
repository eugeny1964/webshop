package com.evgueny.webshop;

import com.evgueny.webshop.model.*;
import com.evgueny.webshop.repository.*;
import com.evgueny.webshop.service.ClientService;
import com.evgueny.webshop.service.GoodService;
import com.evgueny.webshop.service.Order_GoodService;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import javax.persistence.*;


@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(WebShopApplication.class, args);
    }

    @Autowired
    private GoodService goodService;
    @Autowired
    private GoodRepository goodRepository;
    @Autowired
    Order_GoodRepository order_goodRepository;
    @Autowired
    EntityManagerFactory entityManagerFactory;
    @Autowired
    Order_GoodService order_goodService;
    @Autowired
    private ClientService clientService;

    @Override
    public void run(String... args) throws Exception {
        List<Order_Good> order_goodFromGood = goodService.getOrder_goodFromGood(2L);
        System.out.println(order_goodFromGood);

        Good good=goodService.getById(2L);
        List<Order_Good> orderGoods=goodService.getOrder_goodFromGood(2L);
        System.out.println(orderGoods);

        List<Order_Good> orderGood=goodService.getOrder_goodFromGoodOb(good);
        System.out.println(orderGood);



    }
}
