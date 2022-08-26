package com.example.reactive2.bootstrap;

import com.example.reactive2.domain.Movie;
import com.example.reactive2.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class InitMovies implements CommandLineRunner {
    private final MovieRepository movieRepository;
    @Override
    public void run(String... args) throws Exception {
        movieRepository.deleteAll()
                .thenMany(Flux.just("Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5", "Movie 6", "Movie 7"))
                .map(Movie::new)
                .flatMap(movieRepository::save)
                .subscribe(null, null, () ->
                {movieRepository.findAll().subscribe(System.out::println);});
    }
}
