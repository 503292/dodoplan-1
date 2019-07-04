package com.maksym.dodoplan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "taskBody")
    private String taskBody;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "task")
    private Set<User> users;
}
