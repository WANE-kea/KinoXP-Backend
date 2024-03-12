package com.example.kinoxpbackend.kino_server.dto;

import com.example.kinoxpbackend.kino_server.entity.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDto {
    private Integer id;
    private String title;

    public MovieDto(Movie c) {
        this.id = c.getId();
        this.title = c.getTitle();

    }
}