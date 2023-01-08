package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository mr;
    public ResponseEntity<String> addMovie(Movie m){

       return mr.addMovie(m);

}
    public ResponseEntity<String> addDirector(Director d){

        return mr.addDirector(d);
    }

    public ResponseEntity<String> addMovieDirectorPair(String movie,String director){
        Movie m=new Movie();
        m.setName(movie);
        Director d=new Director();
        d.setName(director);
        return mr.addMovieDirectorPair(m,d);
    }

    public ResponseEntity<Director> getDirectorByName(String director){

        return mr.getDirectorByName(director);
    }

    public ResponseEntity<Movie> getMovieByName(String movie){

        return mr.getMovieByName(movie);
    }

    public ResponseEntity<List<String>> getMoviesByDirectorName(String dir){
        return mr.getMoviesByDirectorName(dir);
    }

    public ResponseEntity<List<String>> getAllMovies(){
        return mr.getAllMovies();
    }

    public ResponseEntity<String> deleteDirectorByName(String name) {
        return mr.deleteDirectorByName(name);
    }

    public ResponseEntity<String> deleteAllDirectors()
    {
        return mr.deleteAllDirectors();
    }
}
