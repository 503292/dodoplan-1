package com.maksym.dodoplan.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "chapterName")
    private String chapterName;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "chapter")
    private Set<User> users;
}
