package com.example.kinoxpbackend.kino_server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "theaters", cascade = CascadeType.PERSIST)
    private Set<Theater> theaters;
    public void addTheater(Theater theater) {
        this.theaters.add(theater);
        theater.setTheater(this);
    }
    public Theater(String name) {
        this.name = name;

    }
}