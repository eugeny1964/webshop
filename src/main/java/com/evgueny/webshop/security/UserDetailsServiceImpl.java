package com.evgueny.webshop.security;

import com.evgueny.webshop.model.User;
import com.evgueny.webshop.repository.UserRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepositiry userRepositiry;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User byLogin = userRepositiry.findByLogin(s);
        if (byLogin==null){
            throw new UsernameNotFoundException(String.format("Клиент [%s] не найден"));
        }
        UserDetailsImpl userDetails=new UserDetailsImpl(byLogin);
        return userDetails;
    }
}
