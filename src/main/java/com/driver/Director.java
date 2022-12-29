package com.driver;

import java.util.ArrayList;

public class Director {

    private String name;
    private int numberOfMovies;
    private double imdbRating;
//    private ArrayList<String> movieList;

    public Director(){};

    public Director(String name, int numberOfMovies, double imdbRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.imdbRating = imdbRating;
//        this.movieList= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

//    public ArrayList<String> getGetMovieList() {
//        return movieList;
//    }
//    public void addToList(String movieName){
//
//        movieList.add(movieName);
//
//    }
}
