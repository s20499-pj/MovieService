package pl.pjatk.MovieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.repository.MovieRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if (movie.isPresent()) {
            return movie;
        } else {
            throw new RuntimeException();
        }
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie editMovie(Long id, Movie movie) {
        if (movieRepository.existsById(id)) {
            return movieRepository.save(movie);
        } else {
            throw new RuntimeException();
        }
    }

    public void delete(Long id) {
        if (movieRepository.findById(id).isPresent()) {
            movieRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isAvailable(Long id){
        Movie movie = movieRepository.findById(id).get();
        movie.setAvailable(true);
        return movie.isAvailable();
    }

    public boolean isNotAvailable(Long id) {
        Movie movie = movieRepository.findById(id).get();
        movie.setAvailable(false);
        return movie.isAvailable();
    }
}