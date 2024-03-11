package com.example.kinoxpbackend.kino_server.api;

import com.example.kinoxpbackend.kino_server.entity.Theater;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theaters")
public class TheaterController {

    TheaterController theaterController;

    public TheaterController(TheaterService theaterService) {
        this.theaterController = theaterService;
    }

    @GetMapping
    public List<String> getAllTheaters() {
        return theaterService.getAllTheaters();
    }

}
