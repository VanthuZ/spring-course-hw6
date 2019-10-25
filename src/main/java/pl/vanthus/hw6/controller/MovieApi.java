package pl.vanthus.hw6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.vanthus.hw6.aspect.InfoAfterAddMovie;
import pl.vanthus.hw6.model.Movie;
import pl.vanthus.hw6.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieApi {

    MovieService movieService;

    @Autowired
    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies(){
        return new ResponseEntity<>(movieService.getAllMovies(), HttpStatus.OK);
    }

    @PostMapping
    @InfoAfterAddMovie
    public ResponseEntity addMovie(@RequestBody Movie movie){

        if(movieService.addMovie(movie)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
