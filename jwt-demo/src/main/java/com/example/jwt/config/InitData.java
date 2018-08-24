package com.example.jwt.config;

import com.example.jwt.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class InitData {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @PostConstruct
    public void datainit(){
        PasswordEncoder by = new BCryptPasswordEncoder();
        User user = new User();
        user.setUsername("yang");
        user.setPassword(by.encode("yang"));
        user.setEmail("xmfaly@gmail.com");
        user.setLastPasswordResetDate(new Date());
        user.setEnabled(true);
        Authority authority = new Authority(AuthorityName.ROLE_ADMIN);
        authority = authorityRepository.save(authority);
        user.getAuthorities().add(authority);
        userRepository.save(user);
    }
}
