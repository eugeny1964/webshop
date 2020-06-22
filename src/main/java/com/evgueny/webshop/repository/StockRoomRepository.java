package com.evgueny.webshop.repository;

import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.model.StockRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

public interface StockRoomRepository extends CrudRepository<StockRoom,Long> {
    StockRoom getAllById(Long id);
}
