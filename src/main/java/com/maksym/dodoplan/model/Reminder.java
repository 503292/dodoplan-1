package com.maksym.dodoplan.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "reminder")
public class Reminder {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "title", nullable = false)
        private String title;

        @Column(name = "body", nullable = false)
        private String body;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user;
}
