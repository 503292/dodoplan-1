package com.maksym.dodoplan.controller;

import com.maksym.dodoplan.service.RoleService;
import com.maksym.dodoplan.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class RoleController extends RoleServiceImpl {

    @Autowired
    private RoleService roleService;

}
