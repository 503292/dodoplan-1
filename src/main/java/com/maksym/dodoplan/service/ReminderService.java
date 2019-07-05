package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.ReminderDto;

import java.util.List;

public interface ReminderService {

    ReminderDto save(ReminderDto reminderDto);

    ReminderDto update(ReminderDto reminderDto);

    ReminderDto delete(ReminderDto reminderDto);

    ReminderDto findById(Long id);

    List<ReminderDto> findAllReminder();
}
