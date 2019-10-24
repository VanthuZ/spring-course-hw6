package pl.vanthus.hw6.service;

import org.springframework.stereotype.Service;
import pl.vanthus.hw6.model.Movie;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movieList;

    public MovieService() {
        this.movieList = new ArrayList<>(initSampleMovieList());
    }

    private List<Movie> initSampleMovieList(){

       movieList = Arrays.asList(
                new Movie("Joker", "Todd Phillips", "2019"),
                new Movie("Inception", "Christopher Nolan", "2010")
        );
        return movieList;
    }

    public List<Movie> getAllMovies(){
        return movieList;
    }

    public boolean addMovie(Movie movie) {
        return movieList.add(movie);
    }
}
