package com.example.kinoxpbackend.kino_server.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private String streetAdress;
    private String streetNo;
    private String zip;
    private String country;
    private String phone;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime edited;

    @OneToMany
    private List<Booking> bookings;
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

}


