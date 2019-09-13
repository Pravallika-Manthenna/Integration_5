package com.stackroute.service;

import com.stackroute.domain.Movie;

import java.util.Collection;


public interface MovieService {

   // method to save movie in neo4j database
  String saveMovie(Movie movie);
}
