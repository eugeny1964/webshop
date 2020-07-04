package com.evgueny.webshop.service;

import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.model.Order_Good;
import com.evgueny.webshop.repository.GoodRepository;
import com.evgueny.webshop.repository.Order_GoodRepository;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionTimedOutException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GoodService {

    @Autowired
    private GoodRepository goodRepository;
    @Autowired
    Order_GoodRepository order_goodRepository;

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Good> getAll() {
        return (List<Good>) goodRepository.findAll();
    }

    @Transactional
    public Good getById(Long id) {
        return goodRepository.findById(id).orElseThrow(() -> new RuntimeException("epjgerijger"));
    }
@Transactional
    public List<Good> getByName(String name) {
        if (goodRepository.findAllByName(name).isEmpty()) {
            throw new RuntimeException();
        }
        return goodRepository.findAllByName(name);

    }

    @Transactional
    public void addGood(Good good) {
        goodRepository.save(good);
        throw new RuntimeException();
    }

    @Transactional
    public void testTransaction() {
        Good good = goodRepository.findById(14L).orElseThrow(() -> new RuntimeException());
        good.setName("Nokiaaaaa");
        em.detach(good);
        System.out.println(good);
    }
    @Transactional
    public List<Order_Good> getOrder_goodFromGood(Good good){
        Good good1 = goodRepository.getAllById(2L);
        List<Order_Good> order_good = good1.getOrder_good();
        System.out.println(order_good);
        return order_good;
    }

}
