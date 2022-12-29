package com.driver;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;  //Linking moviecontroller with movieservice class

    @PostMapping("/movies/add-movie")
     ResponseEntity<String> addMovie(@RequestBody Movie movie){

        String message= movieService.addMovie(movie);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PostMapping("/movies/add-director")
     ResponseEntity<String> addDirector(@RequestBody Director director){

        String message= movieService.addDirector(director);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PostMapping("/movies/add-movie-director-pair")
    ResponseEntity<String> addMovieDirectorPair(@RequestParam String movieName ,@RequestParam String directorName){

        String message= movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @GetMapping("/movies/get-movie-by-name/{movieName}")
    ResponseEntity<Movie> getMovieByName(@PathVariable String movieName){

        Movie movie= movieService.getMovieByName(movieName);

        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    @GetMapping("/movies/get-director-by-name/{name}")
    ResponseEntity<Director> getDirectorByName(@PathVariable String name){

        Director director= movieService.getDirectorByName(name);
        return new ResponseEntity<>(director, HttpStatus.OK);
    }
    @GetMapping("/movies/get-movies-by-director-name/{directorName}")
    ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String directorName){

        List<String> listOfMovies= movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(listOfMovies, HttpStatus.OK);
    }
    @GetMapping("/movies/get-all-movies")
    ResponseEntity<List<String>> finAllMovies(){

        List<String> allMovies= movieService.findAllMovies();

        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }
    @DeleteMapping("/movies/delete-all-directors")
    ResponseEntity<String> deleteAllDirectors(){

        return new ResponseEntity<>(movieService.deleteAllDirectors(), HttpStatus.OK);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    ResponseEntity<String> deleteDirectorByName(@RequestParam String directorName){

        return new ResponseEntity<>(movieService.deleteDirectorByName(directorName), HttpStatus.OK);
    }


}
