package com.maksym.dodoplan.controller;

import com.maksym.dodoplan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public String register(){
        return null;

//        TODO

    }


}
