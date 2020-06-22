package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface StatusRepository extends CrudRepository<Status,Long> {
}
