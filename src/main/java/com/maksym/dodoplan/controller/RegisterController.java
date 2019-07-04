package com.maksym.dodoplan.controller;

import com.maksym.dodoplan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")


}
