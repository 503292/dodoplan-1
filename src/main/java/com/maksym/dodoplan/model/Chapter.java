package com.maksym.dodoplan.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "chapterName")
    public String chapterName;
}
