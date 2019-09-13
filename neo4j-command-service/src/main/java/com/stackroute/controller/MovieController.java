package com.stackroute.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.domain.Movie;
import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collection;

@RestController
public class MovieController {

    // autowire the movieService
    @Autowired
    private MovieService movieService;

    ResponseEntity responseEntity;

    String input="";
    ObjectMapper objectMapper=new ObjectMapper();
    Movie movie1=new Movie();
    @KafkaListener(topics = "Fetch-Keyword", groupId = "group_id")
    public void consumer(String message) throws IOException {
        System.out.println("consumed message is "+message);
        Movie movie=objectMapper.readValue(message,Movie.class);
        this.movie1=movie;
        System.out.println("Data in Movie object is"+movie1);
    }

    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    // method to save json data into neo4j as nodes and relationships
    @PostMapping("/saveMovie")
    public ResponseEntity<?> saveMovie() throws IOException {
        String result=(movieService.saveMovie(movie1));
        System.out.println(result);
        if(result!=null)
            responseEntity = new ResponseEntity<String>(result, HttpStatus.CREATED);
        else
            responseEntity = new ResponseEntity<String>(result, HttpStatus.CONFLICT);
        return responseEntity;
    }
}
