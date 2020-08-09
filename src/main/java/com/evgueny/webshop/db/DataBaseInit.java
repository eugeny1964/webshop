package com.evgueny.webshop.db;

import com.evgueny.webshop.model.*;
import com.evgueny.webshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    @Autowired
    AdministratorRepository administratorRepository;
    @Autowired
    OldClientRepository oldClientRepository;

    @PostConstruct
    public void init() {
        LocalDateTime ldt1=LocalDateTime.parse("2020-08-05 17:14:10", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Client client1 = clientRepository.save(new Client("Иван", "password2",ldt1, "Гиляровского 10", "+72222222", "2mail@mail.ru"));
        Client client2 = clientRepository.save(new Client("Владимир", "password3",ldt1.minusDays(1), "Щепкина 4", "+73333333Э", "3mail@mail.ru"));
        Client client3 = clientRepository.save(new Client("Артем", "password4",ldt1.minusDays(2), "Проспект Мира 55", "+74444444", "4mail@mail.ru"));
        Client client4 = clientRepository.save(new Client("Федор", "password5",ldt1.minusDays(3), "Сухаревская 3", "+75555555", "5mail@mail.ru"));
        Client client8 = clientRepository.save(new Client("Миша", "password8",ldt1.minusDays(3), "Сухаревская 9", "+78888888", "8mail@mail.ru"));
        Client client5 = clientRepository.save(new Client("Мария", "password6",ldt1.minusDays(4), "Волгоградский проспект 8", "+76666666", "6mail@mail.ru"));
        Client client6 = clientRepository.save(new Client("Ольга", "password7",ldt1.minusDays(7), "Вавилова 46", "+77777777", "7mail@mail.ru"));
        Client client7 = clientRepository.save(new Client("Надежда", "password8",ldt1.minusDays(9), "Нагорная 44", "+78888888", "8mail@mail.ru"));
        Administrator administrator=administratorRepository.save(new Administrator("Вася","greqterq",ldt1.minusDays(25),"Проспект мира 1","+7890444","sizovzhenya1964@gmail.com"));

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
        Stock_Good stock_good = stock_goodRepository.save(new Stock_Good(1L, 1L, 10));
        Stock_Good stock_good1 = stock_goodRepository.save(new Stock_Good(1L, 1L, 5));

        stock_goodRepository.save(new Stock_Good(1L,3L, 1));
        stock_goodRepository.save(new Stock_Good(1L,5L, 5));
        stock_goodRepository.save(new Stock_Good(1L,7L, 44));
        stock_goodRepository.save(new Stock_Good(2L,1L, 67));
        stock_goodRepository.save(new Stock_Good(3L,10L, 190));
        stock_goodRepository.save(new Stock_Good(3L,9L, 0));
        stock_goodRepository.save(new Stock_Good(3L,8L, 500));
        stock_goodRepository.save(new Stock_Good(2L,10L, 34));
        stock_goodRepository.save(new Stock_Good(2L,7L, 1));

        Delivery delivery=deliveryRepository.save(new Delivery(DeliveryType.HOME,1000D));
        Delivery delivery1=deliveryRepository.save(new Delivery(DeliveryType.OFFICE,1000D));
        Delivery delivery2=deliveryRepository.save(new Delivery(DeliveryType.STORAGE,0D));

        Status status=statusRepository.save(new Status(StatusType.PAID));
        Status status1=statusRepository.save(new Status(StatusType.NOTPADE));

        Orders orders=ordersRepository.save(new Orders(delivery,status,client1,"1"));
        Orders orders1=ordersRepository.save(new Orders(delivery1,status1,client2,"2"));
        Orders orders2=ordersRepository.save(new Orders(delivery2,status,client3,"3"));
        Orders orders3=ordersRepository.save(new Orders(delivery,status1,client4,"4"));
        Orders orders4=ordersRepository.save(new Orders(delivery1,status,client5,"5"));
        Orders orders5=ordersRepository.save(new Orders(delivery2,status1,client6,"6"));

        order_goodRepository.save(new Order_Good(1L,1L,2L));
        order_goodRepository.save(new Order_Good(2L,2L,2L));
        order_goodRepository.save(new Order_Good(3L,3L,1L));
        order_goodRepository.save(new Order_Good(4L,4L,2L));
        order_goodRepository.save(new Order_Good(5L,5L,2L));

        oldClientRepository.save(new OldClient("Петя", "password10",ldt1.minusDays(24), "Гиляровского 15", "+72222222", "2mail@mail.ru"));
        oldClientRepository.save(new OldClient("Олег", "password20",ldt1.minusDays(23), "Гиляровского 25", "+722222", "3mail@mail.ru"));




        //  DeliveryType deliveryType=new DeliveryType();

    }
}
