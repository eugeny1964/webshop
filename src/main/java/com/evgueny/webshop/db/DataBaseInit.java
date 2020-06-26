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
    StockRoomRepository stockRoomRepository;
    @Autowired
    GoodRepository goodRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    StatusRepository statusRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    private Stock_GoodRepository stock_goodRepository;

    @PostConstruct
    public void init(){
/*        Client client1 = clientRepository.save(new Client("Иван", "password2", "Гиляровского 10", "+72222222", "2mail@mail.ru"));
        Client client2 = clientRepository.save(new Client("Владимир", "password3", "Щепкина 4", "+73333333Э", "3mail@mail.ru"));
        Client client3 = clientRepository.save(new Client("Артем", "password4", "Проспект Мира 55", "+74444444", "4mail@mail.ru"));
        Client client4 = clientRepository.save(new Client("Федор", "password5", "Сухаревская 3", "+75555555", "5mail@mail.ru"));
        Client client5 = clientRepository.save(new Client("Мария", "password6", "Волгоградский проспект 8", "+76666666", "6mail@mail.ru"));
        Client client6 = clientRepository.save(new Client("Ольга", "password7", "Вавилова 46", "+77777777", "7mail@mail.ru"));
        Client client7 = clientRepository.save(new Client("Надежда", "password8", "Нагорная 44", "+78888888", "8mail@mail.ru"));*/

/*        StockRoom stock1 = stockRoomRepository.save(new StockRoom("msk-003"));
        StockRoom stock2 = stockRoomRepository.save(new StockRoom("msk-004"));
        StockRoom stock3 = stockRoomRepository.save(new StockRoom("msk-005"));*/

/*        Good good1 = goodRepository.save(new Good("Nokia 4378", 4000D));
        Good good2 = goodRepository.save(new Good("Samsung galaxy s7", 6000.0));*/
 /*       Good good3 = goodRepository.save(new Good("Samsung galaxy s8", 7000.0));
        Good good4 = goodRepository.save(new Good("Samsung galaxy s9", 8000.0));
        Good good5 = goodRepository.save(new Good("Honor 9", 9000.0));
        Good good6 = goodRepository.save(new Good("Honor 10", 12000.0));
        Good good7 = goodRepository.save(new Good("Xiaomi 2", 15000.0));
        Good good8 = goodRepository.save(new Good("Xiaomi 3", 25000.0));
        Good good9 = goodRepository.save(new Good("Apple 4", 50000.0));
        Good good10 = goodRepository.save(new Good("Apple 5", 70000.0));*/

/*        stock_goodRepository.save(new Stock_Good(stock1,good1, 3));
        stock_goodRepository.save(new Stock_Good(stock1,good2, 1));

        Status st1 = statusRepository.save(new Status("Оплачен"));
        Status st2 = statusRepository.save(new Status("Не оплачен"));

        Delivery del1 = deliveryRepository.save(new Delivery("Клиенту на дом", 1D));
        Delivery del2 = deliveryRepository.save(new Delivery("Пункт выдачи", 0.5D));
        Delivery del3 = deliveryRepository.save(new Delivery("Получение на складе", 0D));*/

    }
}
