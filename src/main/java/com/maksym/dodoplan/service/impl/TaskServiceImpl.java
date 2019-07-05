package com.maksym.dodoplan.service.impl;

import com.maksym.dodoplan.exception.ReminderNotFoundException;
import com.maksym.dodoplan.exception.TaskNotFoundException;
import com.maksym.dodoplan.model.Reminder;
import com.maksym.dodoplan.model.Task;
import com.maksym.dodoplan.model.dto.TaskDto;
import com.maksym.dodoplan.repository.ReminderRepository;
import com.maksym.dodoplan.repository.TaskRepository;
import com.maksym.dodoplan.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ReminderRepository reminderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public TaskDto findById(Long id) {
        return taskRepository.findById(id)
                .map(e -> modelMapper.map(e, TaskDto.class))
                .orElseThrow(() -> new TaskNotFoundException("Not found Task with id " + id));
    }

    @Override
    public List<TaskDto> findAllTasks() {
        return taskRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(e -> modelMapper.map(e, TaskDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> findAllTasksByChapter(Long chapterId) {
        return taskRepository.findAllByChapter_Id(chapterId).stream()
                .filter(Objects::nonNull)
                .map(e -> modelMapper.map(e, TaskDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto findTaskByRemainder(Long remainderId) {
        Reminder reminder = reminderRepository.findById(remainderId)
                .orElseThrow(() -> new ReminderNotFoundException("Not found Reminder with id " + remainderId));

        return taskRepository.findByRemindersContains(reminder)
                .map(e -> modelMapper.map(e, TaskDto.class))
                .orElseThrow(() -> new TaskNotFoundException("Not found Task by Reminder with id" + remainderId));
    }

    @Override
    public TaskDto save(TaskDto taskDto) {
        return Optional.of(taskDto)
                .map(e -> modelMapper.map(e, Task.class))
                .map(e -> taskRepository.save(e))
                .map(e -> modelMapper.map(e, TaskDto.class))
                .orElseThrow(() -> new TaskNotFoundException("TaskDto is null. Nothing to save"));
    }

    @Override
    public TaskDto update(TaskDto taskDto) {
        return null;/*Optional.of(taskDto)
                .map(e -> modelMapper.map(e, Task.class))*/

    }

    @Override
    public TaskDto delete(TaskDto taskDto) {
        return null;
    }
}
