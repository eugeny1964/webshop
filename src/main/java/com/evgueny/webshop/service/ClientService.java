package com.evgueny.webshop.service;

import com.evgueny.webshop.model.Client;
import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.model.Order_Good;
import com.evgueny.webshop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Validated
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;

    List<Client> findAll() {
        return (List<Client>) clientRepository.findAll();
    }

    public Client addClient(@Valid @NotNull Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client getClientByLogin(String login) {
        return clientRepository.findByLogin(login);
    }
}
