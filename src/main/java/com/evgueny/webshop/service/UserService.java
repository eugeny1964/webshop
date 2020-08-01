package com.evgueny.webshop.service;

import com.evgueny.webshop.exception.ResourseNotFoundException;
import com.evgueny.webshop.model.User;
import com.evgueny.webshop.repository.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class UserService {
    @Autowired
    UserRepositiry userRepositiry;

    public User getUserById(Long id){
       return userRepositiry.findById(id).orElseThrow(() -> new ResourseNotFoundException("User", id));
    }
    public List<User> getAllUser(){
        return (ArrayList<User>) userRepositiry.findAll();
    }
}
