package com.maksym.dodoplan.service;

import com.maksym.dodoplan.model.dto.ReminderDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ReminderService {

    ReminderDto save(ReminderDto reminderDto);

    void delete(ReminderDto reminderDto);

    ReminderDto findById(Long id);

    List<ReminderDto> findAll();

}
