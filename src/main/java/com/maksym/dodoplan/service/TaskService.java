package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.TaskDto;

import java.util.List;

public interface TaskService {

    TaskDto getById(Long id);

    List<TaskDto> getAllTasks();

    List<TaskDto> getAllTasksByChapter(Long chapterId);

    TaskDto save (TaskDto taskDto);

    TaskDto update (TaskDto taskDto);

    TaskDto delete (TaskDto taskDto);
}
