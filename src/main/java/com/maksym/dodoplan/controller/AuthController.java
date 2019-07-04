package com.maksym.dodoplan.controller;

import com.maksym.dodoplan.model.dto.AuthRequest;
import com.maksym.dodoplan.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> auth(@RequestBody AuthRequest auth){

        return ResponseEntity.ok(authService.auth(auth.getEmail(), auth.getPassword()));
    }
}
