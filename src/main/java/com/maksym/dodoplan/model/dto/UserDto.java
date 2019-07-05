package com.maksym.dodoplan.model.dto;

import lombok.Data;
import java.util.List;
import java.util.Set;

@Data

public class UserDto {

    private Long id;

    private String email;

    private String password;

    private Set<RoleDto> roles;

    private List<ReminderDto> reminders;

    private List<ChapterDto> chapters;

    private List<TaskDto> tasks;
}
