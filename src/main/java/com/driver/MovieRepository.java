package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
class MovieRepository {

    public HashMap<Director, List<Movie>> db = new HashMap<Director, List<Movie>>();

    MovieRepository() {
        db.put(null, null);
    }

    public ResponseEntity<String> addMovie(Movie m) {

        if (!db.get(null).contains(m)) {
            List <Movie>li = db.get(null);
            li.add(m);
            db.put(null, li);
        }
        return new ResponseEntity("success", HttpStatus.OK);

    }

    public ResponseEntity<String> addDirector(Director d) {
        db.put(d, null);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> addMovieDirectorPair(Movie movie, Director director) {
        if (db.get(director) == null) {
            List <Movie>li = new ArrayList<Movie>();
            li.add(movie);
            db.put(director, li);
        } else {
            List <Movie>li = db.get(director);
            li.add(movie);
            db.put(director, li);
        }

        if (db.get(null).contains(movie)) {
            List <Movie>li = db.get(null);
            li.remove(movie);
            db.put(null, li);
        }
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    public ResponseEntity<Director> getDirectorByName(String director) {

        for (Map.Entry<Director, List<Movie>> mp : db.entrySet()) {
            if (mp.getKey().name.equals(director))
                return new ResponseEntity<Director>(mp.getKey(), HttpStatus.OK);
        }
            return null;
    }

    public ResponseEntity<Movie> getMovieByName(String movie){

        for(Map.Entry<Director,List<Movie>> mp:db.entrySet()){
            List <Movie>l=mp.getValue();

            for(int i=0;i<l.size();i++) {
                if (l.get(i).getName().equals(movie))
                    return new ResponseEntity(l.get(i), HttpStatus.OK);
            }
        }
        return null;
    }

}