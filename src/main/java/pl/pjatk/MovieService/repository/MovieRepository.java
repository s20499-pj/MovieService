package pl.pjatk.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.MovieService.model.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Override
    List<Movie> findAll();

    @Override
    Optional<Movie> findById(Long id);

    @Override
    Movie save(Movie movie);

    @Override
    void deleteById(Long id);

}
