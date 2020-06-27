package com.evgueny.webshop.db;

import com.evgueny.webshop.model.*;
import com.evgueny.webshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Profile("loaddata")
public class DataBaseInit {

    @Autowired
    private StockRoomRepository stockRoomRepository;
    @Autowired
    private GoodRepository goodRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private StatusRepository statusRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    private Stock_GoodRepository stock_goodRepository;
    @Autowired
    private Order_GoodRepository order_goodRepository;

    @PostConstruct
    public void init(){
        Client client1 = clientRepository.save(new Client("Иван", "password2", "Гиляровского 10", "+72222222", "2mail@mail.ru"));
        Client client2 = clientRepository.save(new Client("Владимир", "password3", "Щепкина 4", "+73333333Э", "3mail@mail.ru"));
        Client client3 = clientRepository.save(new Client("Артем", "password4", "Проспект Мира 55", "+74444444", "4mail@mail.ru"));
        Client client4 = clientRepository.save(new Client("Федор", "password5", "Сухаревская 3", "+75555555", "5mail@mail.ru"));
        Client client5 = clientRepository.save(new Client("Мария", "password6", "Волгоградский проспект 8", "+76666666", "6mail@mail.ru"));
        Client client6 = clientRepository.save(new Client("Ольга", "password7", "Вавилова 46", "+77777777", "7mail@mail.ru"));
        Client client7 = clientRepository.save(new Client("Надежда", "password8", "Нагорная 44", "+78888888", "8mail@mail.ru"));

        StockRoom stock1 = stockRoomRepository.save(new StockRoom("msk-003"));
        StockRoom stock2 = stockRoomRepository.save(new StockRoom("msk-004"));
        StockRoom stock3 = stockRoomRepository.save(new StockRoom("msk-005"));

        Good good1 = goodRepository.save(new Good("Nokia 4378", 4000D));
        Good good2 = goodRepository.save(new Good("Samsung galaxy s7", 6000.0));
        Good good3 = goodRepository.save(new Good("Samsung galaxy s8", 7000.0));
        Good good4 = goodRepository.save(new Good("Samsung galaxy s9", 8000.0));
        Good good5 = goodRepository.save(new Good("Honor 9", 9000.0));
        Good good6 = goodRepository.save(new Good("Honor 10", 12000.0));
        Good good7 = goodRepository.save(new Good("Xiaomi 2", 15000.0));
        Good good8 = goodRepository.save(new Good("Xiaomi 3", 25000.0));
        Good good9 = goodRepository.save(new Good("Apple 4", 50000.0));
        Good good10 = goodRepository.save(new Good("Apple 5", 70000.0));

        stock_goodRepository.save(new Stock_Good(stock1, good1, 3));
        stock_goodRepository.save(new Stock_Good(stock2,good2, 8));
        stock_goodRepository.save(new Stock_Good(stock3,good3, 5));
        stock_goodRepository.save(new Stock_Good(stock1,good5, 1));
        stock_goodRepository.save(new Stock_Good(stock1,good7, 4));
        stock_goodRepository.save(new Stock_Good(stock2,good1, 44));
        stock_goodRepository.save(new Stock_Good(stock3,good10, 67));
        stock_goodRepository.save(new Stock_Good(stock3,good9, 190));
        stock_goodRepository.save(new Stock_Good(stock3,good8, 0));
        stock_goodRepository.save(new Stock_Good(stock2,good10, 500));
        stock_goodRepository.save(new Stock_Good(stock2,good7, 34));

        Status st1 = statusRepository.save(new Status("Оплачен"));
        Status st2 = statusRepository.save(new Status("Не оплачен"));

        Delivery del1 = deliveryRepository.save(new Delivery("Клиенту на дом", 1D));
        Delivery del2 = deliveryRepository.save(new Delivery("Пункт выдачи", 0.5D));
        Delivery del3 = deliveryRepository.save(new Delivery("Получение на складе", 0D));

        Orders orders1 = ordersRepository.save(new Orders(del1, st1, client1));
        Orders orders2 = ordersRepository.save(new Orders(del2, st2, client2));
        Orders orders3 = ordersRepository.save(new Orders(del3, st1, client3));
        Orders orders4 = ordersRepository.save(new Orders(del1, st2, client4));
        Orders orders5 = ordersRepository.save(new Orders(del2, st1, client5));
        Orders orders6 = ordersRepository.save(new Orders(del3, st2, client6));
        Orders orders7 = ordersRepository.save(new Orders(del1, st1, client7));
        Orders orders8= ordersRepository.save(new Orders(del2, st2, client1));
        Orders orders9 = ordersRepository.save(new Orders(del3, st1, client2));
        Orders orders10 = ordersRepository.save(new Orders(del1, st2, client3));
        Orders orders11 = ordersRepository.save(new Orders(del2, st1, client4));
        Orders orders12 = ordersRepository.save(new Orders(del3, st2, client5));

        order_goodRepository.save(new Order_Good(orders1,good1,3));
        order_goodRepository.save(new Order_Good(orders1,good2,7));
        order_goodRepository.save(new Order_Good(orders1,good3,2));
        order_goodRepository.save(new Order_Good(orders2,good5,1));
        order_goodRepository.save(new Order_Good(orders2,good7,1));
        order_goodRepository.save(new Order_Good(orders2,good9,100));
        order_goodRepository.save(new Order_Good(orders3,good10,200));
    }
}
