package pl.vanthus.hw6.service;

import org.springframework.stereotype.Service;
import pl.vanthus.hw6.model.Movie;


import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    public List<Movie> getSampleMovieList(){

        List<Movie> movieList = Arrays.asList(
                new Movie("Joker", "Todd Phillips", "2019"),
                new Movie("Inception", "Christopher Nolan", "2010")
        );

        return movieList;
    }
}
