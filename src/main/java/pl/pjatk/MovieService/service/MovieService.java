package pl.pjatk.MovieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;

import java.util.List;


@Service
public class MovieService {

    public List<Movie> findAll() {
        return List.of(new Movie(1, "Straszny Film", "horror", "somebody", 5));
    }

    public Movie findById() {
        return new Movie(1, "Straszny Film", "horror", "somebody", 5);
}