package com.evgueny.webshop;

import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.model.StockRoom;
import com.evgueny.webshop.repository.GoodRepository;
import com.evgueny.webshop.repository.StockRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebShopApplication.class, args);
    }

    @Autowired
    StockRoomRepository stockRoomRepository;
    @Autowired
    GoodRepository goodRepository;

    @Override
    public void run(String... args) throws Exception {
/*        goodRepository.save(new Good("dd",4D));
        Good good = goodRepository.getAllByName("dd");
        StockRoom stockRoom=new StockRoom(4L,good);
        stockRoomRepository.save(stockRoom);*/
    }
}
