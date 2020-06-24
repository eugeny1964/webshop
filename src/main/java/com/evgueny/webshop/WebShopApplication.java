package com.evgueny.webshop;

import com.evgueny.webshop.model.*;
import com.evgueny.webshop.repository.*;
import com.evgueny.webshop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.util.List;

@SpringBootApplication
public class WebShopApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(WebShopApplication.class, args);
    }

    @Autowired
    private GoodService goodService;

    @Override
    public void run(String... args) throws Exception {
        List<Good> all = goodService.getAll();
        System.out.println(all);
    }
}
