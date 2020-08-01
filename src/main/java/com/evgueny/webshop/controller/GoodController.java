package com.evgueny.webshop.controller;

import com.evgueny.webshop.exception.ConstraintViolationExeption;
import com.evgueny.webshop.model.Good;
import com.evgueny.webshop.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("api/good")
@Validated
public class GoodController {

    @Autowired
    private GoodService goodService;
    
    @GetMapping
    public ResponseEntity<Object> getAll(@Param(value = "id") Long id){
        if(id==null) {
            return ResponseEntity.ok(goodService.getAll());
        }
        return  ResponseEntity.ok(goodService.getById(id));
    }

    @GetMapping("/{id}")
    public Good getById(@PathVariable Long id){
        return goodService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Good add(@RequestBody Good good){
        return goodService.addGood(good);
    }

    @PutMapping
    public Good update(@Param(value = "id") Long id, @RequestBody @Valid @NotNull Good good) throws ConstraintViolationExeption {
        return goodService.update(id,good);
    }

    @DeleteMapping("/{id}")
    public Good delete(@PathVariable Long id){
        return goodService.deleteById(id);
    }




    
}
