package com.example.kinoxpbackend.kino_server.dto;

import com.example.kinoxpbackend.kino_server.entity.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShowDto{
    private int id;
    private Date startTime;
    private Date endTime;
    private Movie movie;
    private Theater theater;

    public ShowDto(Show s) {
        this.id = s.getId();
        this.startTime = s.getStartTime();
        this.endTime = s.getEndTime();
        this.movie = s.getMovie();
        this.theater = s.getTheater();

    }
}