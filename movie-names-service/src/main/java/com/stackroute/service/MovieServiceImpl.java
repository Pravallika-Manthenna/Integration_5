package com.stackroute.service;

import com.stackroute.model.Movie;
import com.stackroute.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MovieServiceImpl implements MovieService {


    private MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie saveMovie(Movie movie) {
        Movie movieName = new Movie();
        movieName.setName(movie.getName());
        movieRepository.save(movieName);
        return movieName;
    }

    @Override
    public Movie searchByMovieName(String name) {
        Movie toSave = new Movie();
        Movie movie = movieRepository.findByMovieName(name);
        if (movie == null) {
            toSave = movieRepository.save(new Movie(name));
        }
        return toSave;
    }
}