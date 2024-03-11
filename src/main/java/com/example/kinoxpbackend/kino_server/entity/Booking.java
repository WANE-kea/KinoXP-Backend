package com.example.kinoxpbackend.kino_server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(name = "bookings")
public class Booking {
    @Id
    private int id;
    private int customerId;
    private int showId;
    private int bookingNr;

    @JoinTable(
            name = "seat_booking",
            joinColumns = @JoinColumn(
                    name = "seat_id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "booking"
            )
    )
    @OneToMany
    private List<Seat> seats;

}
