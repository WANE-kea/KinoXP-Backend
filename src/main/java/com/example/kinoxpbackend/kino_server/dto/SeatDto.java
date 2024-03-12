package com.example.kinoxpbackend.kino_server.dto;


import com.example.kinoxpbackend.kino_server.entity.Seat;
import com.example.kinoxpbackend.kino_server.entity.Theater;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeatDto {
    private Integer id;
    private int row;
    private int seatNr;
    private boolean available;
    private Theater theater;
    private Seat.seatType type;

    public SeatDto(Seat seat) {
        this.id = seat.getId();
        this.row = seat.getRow();
        this.seatNr = seat.getSeatNr();
        this.available = seat.isAvailable();
        this.theater = seat.getTheater();
        this.type = seat.getType();
    }

}
