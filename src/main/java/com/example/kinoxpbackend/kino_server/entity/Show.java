package com.example.kinoxpbackend.kino_server.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shows")
public class Show {
    @Id
    private int id;
    private int movieId;
    private int theaterId;
    private Date startTime;
    private Date endTime;
}
