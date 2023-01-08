package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie m){
        return movieService.addMovie(m);
    }

    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director d){
        return movieService.addDirector(d);
    }

    @PostMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){

        return movieService.addMovieDirectorPair(movie,director);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String name){
        return movieService.getDirectorByName(name);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movie){
        return movieService.getMovieByName(movie);
    }
}
