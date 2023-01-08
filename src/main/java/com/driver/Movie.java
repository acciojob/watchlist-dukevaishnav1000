package com.driver;

public class Movie {

    String name;
    int durationInMinutes;
    double imdbRating;

    public Movie(){

    }

    public Movie(String name,int durationInMinutes, double imdbRating) {
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
        this.name=name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
