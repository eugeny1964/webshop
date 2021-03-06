package com.evgueny.webshop;

import com.evgueny.webshop.repository.*;
import com.evgueny.webshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.*;

@EnableScheduling
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
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private MailService emailService;
    @Autowired
    private UserRepositiry userRepositiry;


    @Override

    public void run(String... args) throws Exception {
/*        //отдельный метод
        List<Order_Good> order_goodFromGood = goodService.getOrder_goodFromGood(1L);
        System.out.println(order_goodFromGood);
        Client client = new Client("klsfj", "kfslaj", "nvkds", "9070190199", "fhj@nf2l");
        List<Orders> ordersFromClient = clientService.getOrdersFromClient();
        System.out.println(ordersFromClient);*/
   /*     goodService.testExeption();*/

/*       goodService.getAll();
       clientService.getOrdersFromClient();
       goodRepository.findAll();
       clientService.getClientByLogin("");*/
/*        User userById = userService.getUserById(1L);*/
/*        List<User> allUser = userService.getAllUser();*/
/*        Orders byId = ordersService.getById(1L);*/
      /*  emailService.send("sizovzhenya1964@gmail.com","sizovzhenya1964@gmail.com","Hello","How are you?");*/
        //userRepositiry.findAll().forEach(System.out::println);

    }
}
