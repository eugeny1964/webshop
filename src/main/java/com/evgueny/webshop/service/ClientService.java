package com.evgueny.webshop.service;

import com.evgueny.webshop.model.Client;
import com.evgueny.webshop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    List<Client> findAll(){
        return (List<Client>) clientRepository.findAll();
    }
}
