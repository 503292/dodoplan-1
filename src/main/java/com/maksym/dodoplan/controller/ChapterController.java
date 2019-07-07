package com.maksym.dodoplan.controller;

import com.maksym.dodoplan.service.ChapterService;
import com.maksym.dodoplan.service.impl.ChapterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;
}
