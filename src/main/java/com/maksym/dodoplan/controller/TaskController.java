package com.maksym.dodoplan.controller;

import com.maksym.dodoplan.service.TaskService;
import com.maksym.dodoplan.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class TaskController extends TaskServiceImpl {

    @Autowired
    private TaskService taskService;

}
