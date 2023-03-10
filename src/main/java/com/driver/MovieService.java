package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    public MovieRepository movieRepository;

    public String addMovie(Movie movie){

        String message= movieRepository.addMovie(movie);
        return message;
    }

    public String addDirector(Director director){

        String message= movieRepository.addDirector(director);
        return message;

    }
    public String addMovieDirectorPair(String movieName, String directorName){

        return movieRepository.addMovieDirectorPair(movieName, directorName);
    }
    public Movie getMovieByName(String movieName){

        return movieRepository.getMovieByName(movieName);
    }
    public Director getDirectorByName(String directorName){

        return movieRepository.getDirectorByName(directorName);
    }
    public List<String> getMoviesByDirectorName(String directorName){

        return movieRepository.getMovieByDirectorName(directorName);
    }
    public List<String> findAllMovies(){

        return movieRepository.findAllMovies();
    }
    public String deleteDirectorByName(String directorName){

        return movieRepository.deleteDirectorByName(directorName);
    }
    public String deleteAllDirectors(){
        return movieRepository.deleteAllDirectors();
    }

}
