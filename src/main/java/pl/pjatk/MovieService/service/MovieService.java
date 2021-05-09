package pl.pjatk.MovieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;

import java.util.List;

import static pl.pjatk.MovieService.model.Category.Horror;


@Service
public class MovieService {

    public List<Movie> findAll() {
        return List.of(new Movie(1, "Straszny Film", Horror, "somebody", 5));
    }

    public Movie findById() {
        return new Movie(1, "Straszny Film", Horror, "somebody", 5);
    }

    public Movie addMovie(Movie movie){
        return movie;
    }

    public Movie editMovie(int id, Movie movie) {
        return new Movie(id, movie.getTitle(), movie.getCategory(), movie.getDirector(), movie.getRating());
    }

    public void delete(Long id) {
    }
}