package com.maksym.dodoplan.model.dto;

import com.maksym.dodoplan.model.User;
import lombok.*;

@Data
public class ReminderDto {

    private Long id;

    private String title;

    private String body;

//    private User user;

}
