package pl.vanthus.hw6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    public List<Movie> getMovies(){
        return movieService.getSampleMovieList();
    }
}
