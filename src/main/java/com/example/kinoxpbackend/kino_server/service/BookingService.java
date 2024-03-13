package com.example.kinoxpbackend.kino_server.service;

import com.example.kinoxpbackend.kino_server.dto.BookingDto;
import com.example.kinoxpbackend.kino_server.entity.Booking;
import com.example.kinoxpbackend.kino_server.entity.Seat;
import com.example.kinoxpbackend.kino_server.repository.BookingRepository;
import com.example.kinoxpbackend.kino_server.repository.SeatRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class BookingService {

    final BookingRepository bookingRepository;
    final SeatRepository seatRepository;

    public BookingService(BookingRepository bookingRepository, SeatRepository seatRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map((b) -> new BookingDto(b)).toList();
    }

    public BookingDto getBookingById(String id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
        return new BookingDto(booking);
    }

    public BookingDto addBooking(BookingDto request) {
        if (request.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide the id for a new booking!");
        }
        List<Seat> seats = request.getSeats();
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = seatRepository.findById(seats.get(i).getId()).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found"));
            if (!seat.isAvailable()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seat is out of commission!");
        }
        Booking newBooking = new Booking();
        newBooking.setId(UUID.randomUUID().toString());
        updateBooking(newBooking, request);
        bookingRepository.save(newBooking);
        return new BookingDto(newBooking);
    }

    private void updateBooking(Booking original, BookingDto b) {
        original.setCustomer(b.getCustomer());
        original.setShow(b.getShow());
        original.setSeats(b.getSeats());
    }

    public BookingDto editBooking(BookingDto request, String id) {
        if (!Objects.equals(request.getId(), id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing booking");
        }
        List<Seat> seats = request.getSeats();
        for (int i = 0; i < seats.size(); i++) {
            Seat seat = seatRepository.findById(seats.get(i).getId()).orElseThrow(() ->
                    new ResponseStatusException(HttpStatus.NOT_FOUND, "Seat not found"));
            if (!seat.isAvailable()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Seat is out of commission!");
        }
        Booking bookingToEdit = bookingRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
        updateBooking(bookingToEdit,request);
        bookingRepository.save(bookingToEdit);
        return new BookingDto(bookingToEdit);
    }

    public ResponseEntity deleteBooking(int id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
        bookingRepository.delete(booking);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}