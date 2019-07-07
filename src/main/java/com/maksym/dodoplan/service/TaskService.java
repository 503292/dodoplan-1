package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {

    TaskDto findById(Long id);

    List<TaskDto> findAllTasks();

    List<TaskDto> findAllTasksByChapter(Long chapterId);

    TaskDto findTaskByRemainder(Long remainderId);

    TaskDto save (TaskDto taskDto);

    TaskDto update (TaskDto taskDto);

    TaskDto delete (TaskDto taskDto);
}
