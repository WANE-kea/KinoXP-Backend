package com.example.kinoxpbackend.kino_server.entity;


import com.example.kinoxpbackend.security.entity.Customer;
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
    private String id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Show show;
    @OneToMany
    private List<Seat> seats;

}
