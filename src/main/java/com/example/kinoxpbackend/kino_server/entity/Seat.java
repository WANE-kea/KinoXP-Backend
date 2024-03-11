package com.example.kinoxpbackend.kino_server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "seats")
public class Seat {
    @Id
    private int id;
    private int row;
    private int seatNr;
    private boolean available;
    private int theaterId;
    private enum seatType {
        REGULAR,
        VIP,
        HANDICAP
    }
    private seatType type;
}
