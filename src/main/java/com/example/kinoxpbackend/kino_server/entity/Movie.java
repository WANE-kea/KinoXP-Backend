package com.example.kinoxpbackend.kino_server.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private String posterBase64;
    private String posterUrl;
    private String trailerUrl;
    private int ageLimit;
    private int duration;
    @ManyToMany(mappedBy = "movies")
    @JsonManagedReference
    private List<Category> categories;
    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<Show> shows;
}
