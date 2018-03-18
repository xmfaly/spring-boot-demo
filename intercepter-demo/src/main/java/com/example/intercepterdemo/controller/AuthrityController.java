package com.example.intercepterdemo.controller;

import com.example.intercepterdemo.intercepter.NoAuth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthrityController {


    @PostMapping("/auth")
    @NoAuth
    public Object auth(String uname, String pwd, HttpServletRequest request){

        Map<String,String> map = new HashMap<>();
        if(uname.equals("admin") && pwd.equals("admin")){
            request.getSession().setAttribute("admin",true);
            map.put("code","0");
            map.put("msg","登陆成功");
        }else {
            map.put("code","1");
            map.put("msg","用户名或密码错误");
        }
        return map;
    }

    @GetMapping("/testAuth")
    public Object testAuth(){
        return "你好！管理员";
    }
}
