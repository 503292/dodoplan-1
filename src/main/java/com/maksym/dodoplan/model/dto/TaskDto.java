package com.maksym.dodoplan.model.dto;

import com.maksym.dodoplan.model.Chapter;
import lombok.Data;

@Data
public class TaskDto {

    private Long id;

    private String title;

    private String body;

    private Long userId;

    private ChapterDto chapter;
}
