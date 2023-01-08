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

        List<Movie> li=db.get(null);
        for(int i=0;i<li.size();i++){
            if(li.get(i).getName().equals(m.getName()))
                return new ResponseEntity("success", HttpStatus.OK);
        }

        li.add(m);
        db.put(null,li);
        return new ResponseEntity("success", HttpStatus.OK);

    }

    public ResponseEntity<String> addDirector(Director d) {
        db.put(d, null);
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }

    public ResponseEntity<String> addMovieDirectorPair(Movie movie, Director director) {

        for (Map.Entry<Director, List<Movie>> mp : db.entrySet()) {
            if (mp.getKey().getName().equals(director.getName()))
            {
                    List <Movie> li=mp.getValue();
                    li.add(movie);
                    db.put(mp.getKey(),li);
                return new ResponseEntity<String>("success", HttpStatus.OK);
            }

        }
        return new ResponseEntity<String>("success", HttpStatus.OK);
        }


    public ResponseEntity<Director> getDirectorByName(String director) {

        for (Map.Entry<Director, List<Movie>> mp : db.entrySet()) {
            if (mp.getKey().getName().equals(director))
                return new ResponseEntity<Director>(mp.getKey(), HttpStatus.OK);
        }
            return null;
    }

    public ResponseEntity<Movie> getMovieByName(String movie){

        for(Map.Entry<Director,List<Movie>> mp:db.entrySet()){
            List <Movie>l=mp.getValue();

            for(int i=0;i<l.size();i++) {
                if (l.get(i).getName().equals(movie) && mp.getKey()!=null )
                    return new ResponseEntity(l.get(i), HttpStatus.OK);
            }
        }
        return null;
    }

    public ResponseEntity<List<Movie>> getMoviesByDirectorName(String dir)
    {
        for(Map.Entry<Director,List<Movie>> mp:db.entrySet()){
            if(mp.getKey().getName().equals(dir))
                return new ResponseEntity<List<Movie>>(mp.getValue(),HttpStatus.OK) ;
        }
        return null;
    }
}