package com.stackroute.controller;

import com.stackroute.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class MovieController
{

    MovieService movieService;

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private static final String TOPIC = "Fetch_Moviename";

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("save/{name}")
    public ResponseEntity<?> saveMovie(@PathVariable("name") String name) {

            ResponseEntity responseEntity;
            try {
                responseEntity = new ResponseEntity<>(movieService.searchByMovieName(name), HttpStatus.OK);
            } catch (Exception e) {
                responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
            }


            this.kafkaTemplate.send(TOPIC, name);
            System.out.println("Data is produced");
            return responseEntity;


    }

}