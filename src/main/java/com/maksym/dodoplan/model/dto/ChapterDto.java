package com.maksym.dodoplan.model.dto;

import lombok.Data;
import java.util.List;

@Data
public class ChapterDto {

    private Long id;

    private String title;

    private UserDto user;

    private List<TaskDto> tasks;
}
