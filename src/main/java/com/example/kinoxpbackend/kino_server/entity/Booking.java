package com.example.kinoxpbackend.kino_server.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private int customerId;
    private int showId;

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
