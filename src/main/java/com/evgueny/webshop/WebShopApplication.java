package com.evgueny.webshop;

import com.evgueny.webshop.model.*;
import com.evgueny.webshop.repository.*;
import com.evgueny.webshop.service.ClientService;
import com.evgueny.webshop.service.GoodService;
import com.evgueny.webshop.service.Order_GoodService;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import javax.persistence.*;
import javax.transaction.Transactional;


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
/*        //отдельный метод
        List<Order_Good> order_goodFromGood = goodService.getOrder_goodFromGood(1L);
        System.out.println(order_goodFromGood);
        Client client = new Client("klsfj", "kfslaj", "nvkds", "9070190199", "fhj@nf2l");
        List<Orders> ordersFromClient = clientService.getOrdersFromClient();
        System.out.println(ordersFromClient);*/
   /*     goodService.testExeption();*/
    }
}
