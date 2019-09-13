package com.stackroute.controller;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.stackroute.domain.Movie;
import com.stackroute.service.MoviePopulatorService;
import com.stackroute.service.MoviePopulatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.stackroute.service.MoviePopulatorServiceImpl.*;

@RestController
public class MoviePopulatorController {

    // autowire MoviePopulatorService
    @Autowired
    MoviePopulatorService moviePopulatorService;

    public MoviePopulatorController(MoviePopulatorService moviePopulatorService) {
        this.moviePopulatorService = moviePopulatorService;
    }
    // method to store movie data from Omdb to neo4j
    @GetMapping("/fetch-movies")
    public void fetch() throws IOException {
        moviePopulatorService.fetchDataFromOmdbApi();
    }

    // method to store movie data from Omdb to neo4j
    @GetMapping("/save-movies")
    public void save() throws IOException {
        moviePopulatorService.saveDataFromCsv();
    }


}