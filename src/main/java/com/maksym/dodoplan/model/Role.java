package com.maksym.dodoplan.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String name;

    @Column
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private Set<User> users;
}
