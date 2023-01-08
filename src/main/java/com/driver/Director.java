package com.driver;

public class Director {
    String name;
    int numberOfMovies;

    public String getName() {
        return name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    double imdbRating;

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }
}
