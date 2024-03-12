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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int row;
    private int seatNr;
    private boolean available;
    @ManyToOne
    private Theater theater;
    public enum seatType {
        REGULAR,
        VIP,
        HANDICAP
    }
    private seatType type;
}
