package com.stackroute.model;


//package com.stackroute.movie.model;
import org.springframework.data.annotation.Id;

public class Movie
{

    @Id
    private String name;

    public Movie() {
    }

    public Movie( String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{name=" +(name) +
                '}';
    }
}
