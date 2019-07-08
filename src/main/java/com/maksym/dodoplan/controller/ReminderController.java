package com.maksym.dodoplan.controller;

import com.maksym.dodoplan.service.ReminderService;
import com.maksym.dodoplan.service.impl.ReminderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ReminderController {
  
    @Autowired
    private ReminderService reminderService;

    
}
