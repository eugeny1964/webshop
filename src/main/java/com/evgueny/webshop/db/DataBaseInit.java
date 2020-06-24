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
        Client client1 = clientRepository.save(new Client("bob", "password1", "generala 1", "+712345678", "fdscd@vfsav"));

        StockRoom stock1 = stockRoomRepository.save(new StockRoom("msk-001"));

        Good good1 = goodRepository.save(new Good("Nokia 4378", 4000D));
        Good good2 = goodRepository.save(new Good("Samsung galaxy s7", 5898.10));

        stock_goodRepository.save(new Stock_Good(stock1,good1, 3));
        stock_goodRepository.save(new Stock_Good(stock1,good2, 1));

        Status st1 = statusRepository.save(new Status("Оплачен"));
        Status st2 = statusRepository.save(new Status("Не оплачен"));

        Delivery del1 = deliveryRepository.save(new Delivery("Клиенту на дом", 1D));
        Delivery del2 = deliveryRepository.save(new Delivery("Пункт выдачи", 0.5D));
        Delivery del3 = deliveryRepository.save(new Delivery("Получение на складе", 0D));

    }
}
