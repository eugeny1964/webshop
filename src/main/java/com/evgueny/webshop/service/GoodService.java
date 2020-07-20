package com.evgueny.webshop.service;

import com.evgueny.webshop.exception.ConstraintViolationExeption;
import com.evgueny.webshop.exception.ResourseNotFoundException;
import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.model.Order_Good;
import com.evgueny.webshop.repository.GoodRepository;
import com.evgueny.webshop.repository.Order_GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


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


    public Good getById(Long id) {
        return goodRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Товар", id));
    }

    @Transactional
    public List<Good> getByName(String name) {
        if (goodRepository.findAllByName(name).isEmpty()) {
            throw new RuntimeException();
        }
        return goodRepository.findAllByName(name);
    }

    public Good addGood(Good good) {
        return goodRepository.save(good);
    }

    @Transactional
    public void testTransaction() {
        Good good = goodRepository.findById(14L).orElseThrow(() -> new RuntimeException());
        good.setName("Nokiaaaaa");
        em.detach(good);
        System.out.println(good);
    }

    @Transactional
    public List<Order_Good> getOrder_goodFromGood(Long id) {
        Good good = goodRepository.getAllById(id);
        List<Order_Good> order_good = good.getOrder_good();
        System.out.println(order_good);
        return order_good;
    }

    public Good deleteById(Long id) {
        Good good = goodRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Товар", id));
        goodRepository.deleteById(id);
        return good;
    }

    @Transactional
    public Good update(Long id, Good good) throws ConstraintViolationExeption {
        Good good1 = goodRepository.findById(id).orElseThrow(() -> new ResourseNotFoundException("Товар", id));
        if(good.getPrice()<=00.0){
            throw new ConstraintViolationExeption("Цена должна быть больше нуля");
        }else {
            good1.setPrice(good.getPrice());
            good1.setName(good.getName());
            return good1;
        }
    }
    public Good testExeption(){
        Good good=goodRepository.getAllById(1L);
        good=null;
        if(good == null) throw new NullPointerException("klgjlkgjlg  mkla;kgkeg");
         System.out.println(good);
            return good;


    }
}
