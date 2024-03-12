package com.example.kinoxpbackend.kino_server.dto;

import com.example.kinoxpbackend.kino_server.entity.Booking;
import com.example.kinoxpbackend.kino_server.entity.Seat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDto{
    private UUID id;
    private int customerId;
    private int showId;
    private List<Seat> seats;

    public BookingDto(Booking b) {
        this.id = b.getId();
        this.customerId = b.getCustomerId();
        this.showId = b.getShowId();
        this.seats = b.getSeats();
    }
}
