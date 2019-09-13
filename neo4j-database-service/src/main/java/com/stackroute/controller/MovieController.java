package com.stackroute.controller;


import com.stackroute.model.Node;
import com.stackroute.service.MovieService;
import com.stackroute.service.MovieServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/neo4j")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/graph/{nodelabel}/{relation}")
    public Collection<Node> getdata(@PathVariable String nodelabel, @PathVariable String relation)
    {
        return (Collection<Node>) movieService.getData(nodelabel,relation);
    }
    @GetMapping("/graph1/{nodelabel1}/{nodelabel2}")
    public Collection<Node> getdata2labels(@PathVariable String nodelabel1,@PathVariable String nodelabel2)
    {
        return (Collection<Node>) movieService.getDataforDoubleNode(nodelabel1,nodelabel2);
    }
}

