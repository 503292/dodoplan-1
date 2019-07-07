package com.maksym.dodoplan.service.impl;

import com.maksym.dodoplan.exception.ReminderNotFoundException;
import com.maksym.dodoplan.model.Reminder;
import com.maksym.dodoplan.model.dto.ReminderDto;
import com.maksym.dodoplan.repository.ReminderRepository;
import com.maksym.dodoplan.exception.UserNotFoundException;
import com.maksym.dodoplan.service.ReminderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class ReminderServiceImpl implements ReminderService {

    @Autowired
    ReminderRepository reminderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ReminderDto save(ReminderDto reminderDto) {

        return Optional.of(reminderDto)
                .map(e -> modelMapper.map(e, Reminder.class))
                .map(e -> reminderRepository.save(e))
                .map(e -> modelMapper.map(e, ReminderDto.class))
                .orElseThrow(() -> new ReminderNotFoundException("ReminderDto is null Object. Nothing to save"));
    }

    @Override
    public void delete(ReminderDto reminderDto) {

        Reminder reminder = Optional.of(reminderDto)
                .map(e -> modelMapper.map(e, Reminder.class))
                .orElseThrow(() -> new ReminderNotFoundException("ReminderDto is null Object. Nothing to save"));

        reminderRepository.delete(reminder);
    }

    @Override
    public ReminderDto findById(Long id) {

        return reminderRepository.findById(id)
                .map(e -> modelMapper.map(e, ReminderDto.class))
                .orElseThrow(() -> new ReminderNotFoundException("Reminder with id " + id + "not found"));
    }

    @Override
    public List<ReminderDto> findAll() {

        return reminderRepository.findAll().stream()
                .filter(Objects::nonNull)
                .map(e -> modelMapper.map(e, ReminderDto.class))
                .collect(Collectors.toList());
    }
}
