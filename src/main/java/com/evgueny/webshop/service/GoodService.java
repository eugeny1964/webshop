package com.evgueny.webshop.service;

import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodService {

    @Autowired
    private GoodRepository goodRepository;

    public List<Good> getAll(){
        return (List<Good>) goodRepository.findAll();
    }

}
