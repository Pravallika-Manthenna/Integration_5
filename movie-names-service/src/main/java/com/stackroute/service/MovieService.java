package com.stackroute.service;
import com.stackroute.model.Movie;

public interface MovieService
{
    Movie saveMovie(Movie movie);

    public Movie searchByMovieName(String name);
}
