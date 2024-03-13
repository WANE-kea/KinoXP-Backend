package com.example.kinoxpbackend.kino_server.service;

import com.example.kinoxpbackend.kino_server.dto.ShowDto;
import com.example.kinoxpbackend.kino_server.entity.Show;
import com.example.kinoxpbackend.kino_server.repository.ShowRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class ShowService {

    ShowRepository showRepository;

    public ShowService(ShowRepository showRepository) {
        this.showRepository = showRepository;
    }
    public List<ShowDto> getAllShows() {
        List<Show> shows = showRepository.findAll();
        return shows.stream().map((t)->new ShowDto(t)).toList();
    }

    public ShowDto getShowById(int id) {
        Show show = showRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
        return new ShowDto(show);
    }

    public ShowDto addShow(ShowDto request) {
        if (request.getId() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Show id is required");
        }
        Show newShow = new Show();
        updateShow(newShow, request);
        showRepository.save(newShow);
        return new ShowDto(newShow);
    }

    private void updateShow(Show original, ShowDto s) {
        original.setStartTime(s.getStartTime());
        original.setEndTime(s.getEndTime());
        original.setMovie(s.getMovie());
        original.setTheater(s.getTheater());
    }

    public ShowDto editShow(ShowDto request, int id) {
        if (request.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing show");
        }

        Show showToEdit = showRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
        updateShow(showToEdit,request);
        showRepository.save(showToEdit);
        return new ShowDto(showToEdit);
    }

    public ResponseEntity deleteShow(int id) {
        Show show = showRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Show not found"));
        showRepository.delete(show);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
