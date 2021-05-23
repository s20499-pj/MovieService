package pl.pjatk.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.pjatk.MovieService.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
