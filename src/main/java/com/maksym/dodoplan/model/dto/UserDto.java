package com.maksym.dodoplan.model.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotEmpty
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$" )
    private String email;

    @NotEmpty
    @Pattern(regexp = "^.*(?=.{8,})((?=.*[!@#$%^&*()\\-_=+{};:,<.>]){1})(?=.*\\d)((?=.*[a-z]){1})((?=.*[A-Z]){1}).*$",
            message = "Password must contains 8 symbols. At least one must be uppercase letter, one - lower case, one - digit and one special character")
    private String password;

    private String firstname;

    private String secondname;

    private Set<RoleDto> roles;

    private List<ReminderDto> reminders;

    private List<ChapterDto> chapters;

    private List<TaskDto> tasks;
}
