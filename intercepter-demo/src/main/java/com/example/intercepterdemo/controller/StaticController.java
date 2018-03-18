package com.example.intercepterdemo.controller;

import com.example.intercepterdemo.intercepter.NoAuth;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticController {

    @GetMapping("/login")
    @NoAuth
    public String loginPage(){
        return "login";
    }
}
