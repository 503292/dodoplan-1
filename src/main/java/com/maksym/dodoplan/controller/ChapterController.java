package com.maksym.dodoplan.controller;

import com.maksym.dodoplan.model.User;
import com.maksym.dodoplan.security.JwtUser;
import com.maksym.dodoplan.service.ChapterService;
import com.maksym.dodoplan.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/chapters")

public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private TokenService tokenService;

    @GetMapping(value = "")
    public ResponseEntity<?> getAllChapters(Principal principal) {

        JwtUser user = (JwtUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(user.getId());

        return new ResponseEntity<>(SecurityContextHolder.getContext().getAuthentication().getName(), HttpStatus.OK);
    }
}
