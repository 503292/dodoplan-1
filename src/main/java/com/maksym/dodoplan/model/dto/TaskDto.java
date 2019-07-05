package com.maksym.dodoplan.model.dto;

import lombok.Data;

@Data
public class TaskDto {

    private Long id;

    private String title;

    private String body;

    private UserDto user;

    private ChapterDto chapter;
}
