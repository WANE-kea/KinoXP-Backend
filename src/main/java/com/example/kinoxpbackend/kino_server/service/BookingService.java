package com.example.kinoxpbackend.kino_server.service;

import com.example.kinoxpbackend.kino_server.dto.BookingDto;
import com.example.kinoxpbackend.kino_server.entity.Booking;
import com.example.kinoxpbackend.kino_server.entity.Seat;
import com.example.kinoxpbackend.kino_server.repository.BookingRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {

    final BookingRepository bookingRepository;
    final SeatRepository seatRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
        this.seatRepository = seatRepository;
    }

    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream().map((b) -> new BookingDto(b)).toList();
    }

    public BookingDto getBookingById(UUID id) {
        Booking booking = bookingRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Booking not found"));
        return new BookingDto(booking);
    }

    public BookingDto addBooking(BookingDto request) {
        if (request.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot provide the id for a new booking!");
        }
        Seat seats = seatRepository.findById(request.getSeats()).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Only valid seats are allowed"));
        Booking newBooking = new Booking();
        updateBooking(newBooking, request);
        bookingRepository.save(newBooking);
        return new BookingDto(newBooking);
    }

    private void updateBooking(Booking original, BookingDto b) {
        original.setCustomerId(b.getCustomerId());
        original.setShowId(b.getShowId());
        original.setSeats(b.getSeats());
    }

    public BookingDto editBooking(BookingDto request, UUID id) {
        if (request.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing booking");
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