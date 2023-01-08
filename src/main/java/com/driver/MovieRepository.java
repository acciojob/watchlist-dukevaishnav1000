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

    public ResponseEntity<List<String>> getMoviesByDirectorName(String dir)
    {
        List <String> li=null;
        for(Map.Entry<Director,List<Movie>> mp:db.entrySet()){
            if(mp.getKey().getName().equals(dir))
            {
                for(int i=0;i<mp.getValue().size();i++)
                {
                    li.add(mp.getValue().get(i).getName());
                }
                return new ResponseEntity<List<String>>(li,HttpStatus.OK) ;
            }

        }
        return null;
    }

    public ResponseEntity<List<String>> getAllMovies()
    {
        List <Movie> li=db.get(null);
        List<String> listring=null;
        for(int i=0;i<li.size();i++)
        {
            listring.add(li.get(i).getName());
        }
        return new ResponseEntity<List<String>>(listring,HttpStatus.OK);
    }

    public ResponseEntity<String> deleteDirectorByName(String name)
    {
        for(Map.Entry<Director,List<Movie>> mp: db.entrySet()){
            if(mp.getKey().getName().equals(name))
            {
                db.remove(mp.getKey());
                return new ResponseEntity<String>("success",HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("success",HttpStatus.OK);
    }

    public ResponseEntity<String> deleteAllDirectors()
    {
        List<Movie> li=db.get(null);
        db=new HashMap<Director, List<Movie>>();
        db.put(null,li);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}