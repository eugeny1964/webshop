package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;


public interface ClientRepository extends CrudRepository<Client,Long> {
    Client findByLogin(String login);
}
