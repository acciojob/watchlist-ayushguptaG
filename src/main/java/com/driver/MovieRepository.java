package com.driver;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    public HashMap<String,Movie> watchlistByMovie = new HashMap<>();
    public HashMap<String,Director> watchlistByDirector = new HashMap<>();
    public HashMap<String, List<String>> movieDirectorPair= new HashMap<>();

    public List<String> listOfMovies= new ArrayList<>();
    public String addMovie(Movie movie){
        String movieName= movie.getName();
        watchlistByMovie.put(movieName, movie);

        return "success";
    }
    public String addDirector(Director director){

        String directorName= director.getName();
        watchlistByDirector.put(directorName,director);

        return "success";
    }
    public Movie getMovieByName(String movieName) {

        return watchlistByMovie.getOrDefault(movieName, null);
    }
    public Director getDirectorByName(String directorName){

        return watchlistByDirector.getOrDefault(directorName, null);
    }
    public List<String> getMovieByDirectorName(String directorName){

        for(String name :movieDirectorPair.keySet()){
            if(name.equals(directorName)){
                return movieDirectorPair.get(name);
            }
        }
        return null;
    }
    public String addMovieDirectorPair(String movieName, String directorName){

        if(!movieDirectorPair.containsKey(directorName)){
            movieDirectorPair.put(directorName, new ArrayList<String>());
        }
        movieDirectorPair.get(directorName).add(movieName);

        return "success";
    }
    public List<String> findAllMovies(){

        for(String name : watchlistByMovie.keySet()){
            if(!listOfMovies.contains(name))
                listOfMovies.add(name);
        }
        return listOfMovies;

    }
    public String deleteDirectorByName(String directorName){

        deleteMovies(directorName);
        movieDirectorPair.remove(directorName);
        watchlistByDirector.remove(directorName);

        return "success";
    }
    public String deleteAllDirectors(){
        for(List<String> allMovies : movieDirectorPair.values()) {
            for (String movie : allMovies){
                watchlistByMovie.remove(movie);
                listOfMovies.remove(movie);
            }
        }

        movieDirectorPair.clear();
        watchlistByDirector.clear();
        return "success";
    }
    public void deleteMovies(String name){

        outer:
        for(String director: movieDirectorPair.keySet()){

            if(director.equals(name)){
                for(String movie : movieDirectorPair.get(director)){
                    watchlistByMovie.remove(movie);
                    listOfMovies.remove(movie);
                }
                break outer;
            }
        }
    }
}
