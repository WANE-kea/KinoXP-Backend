package com.example.kinoxpbackend.kino_server.entity;

package com.example.kinoxpbackend.kino_server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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


    @ManyToMany(mappedBy = "theaters", cascade = CascadeType.PERSIST)
