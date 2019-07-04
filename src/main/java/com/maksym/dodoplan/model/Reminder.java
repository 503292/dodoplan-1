package com.maksym.dodoplan.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "reminder")
public class Reminder {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(name = "reminderTitle")
        private String reminderTitle;

        @NotNull
        @Column(name = "reminderBody")
        private String reminderBody;
}
