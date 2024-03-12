package com.example.kinoxpbackend.kino_server.service;

import com.example.kinoxpbackend.kino_server.dto.MovieDto;
import com.example.kinoxpbackend.kino_server.entity.Movie;
import com.example.kinoxpbackend.kino_server.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<String> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map((c)->new String(c.getTitle())).toList();
    }

    public MovieDto getMovieById(int idInt) {
        Movie movie = movieRepository.findById(idInt).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        return new MovieDto(movie);
    }

    public MovieDto addMovie(MovieDto request) {
        if (request.getTitle() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Movie name is required");
        }
        Movie newMovie = new Movie();
        updateMovie(newMovie, request);
        movieRepository.save(newMovie);
        return new MovieDto(newMovie);
    }

    private void updateMovie(Movie original, MovieDto movie) {
        original.setTitle(movie.getTitle());
    }

    public MovieDto editMovie(MovieDto request, int id) {
        if (request.getId() != id) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "You cannot change the id of an existing movie");
        }


        Movie movieToEdit = movieRepository.findById(id).orElseThrow(()
                -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        updateMovie(movieToEdit,request);
        movieRepository.save(movieToEdit);
        return new MovieDto(movieToEdit);
    }


    public ResponseEntity deleteMovie(int id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found"));
        movieRepository.delete(movie);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
