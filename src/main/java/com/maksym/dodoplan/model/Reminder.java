package com.maksym.dodoplan.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "reminder")
public class Reminder {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "title", nullable = false)
        private String title;

        @Column(name = "time", nullable = false)
        private LocalDateTime time;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "task_id")
        private Task task;

        @OneToMany(mappedBy = "reminder", fetch = FetchType.LAZY)
        private List<Task> tasks;
}
