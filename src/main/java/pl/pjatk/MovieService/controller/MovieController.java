package pl.pjatk.MovieService.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> findAllMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> findById(@PathVariable Long id) {
        Optional<Movie> movie = movieService.findById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Movie> add(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> update(@PathVariable Long id, @RequestBody Movie movie) {
        movieService.editMovie(id, movie);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/true")
    public ResponseEntity<Movie> availableIsTrue(@PathVariable Long id) {
        if(movieService.isAvailable(id)) {
            return ResponseEntity.ok().build();
        }else return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}/false")
    public ResponseEntity<Movie> availableIsFalse(@PathVariable Long id) {
        if(movieService.isNotAvailable(id)) {
            return ResponseEntity.ok().build();
        }else return ResponseEntity.badRequest().build();
    }
}