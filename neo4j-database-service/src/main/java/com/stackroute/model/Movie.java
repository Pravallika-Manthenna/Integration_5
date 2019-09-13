package com.stackroute.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Movie {

    private String duration;
    private String imdbId;
    private String title;
    private String summary;
    private String awards;
    public Movie()
    {

    }

    public Movie(String duration, String imdbId, String title, String summary, String awards) {
        this.duration = duration;
        this.imdbId = imdbId;
        this.title = title;
        this.summary = summary;
        this.awards = awards;
    }


    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }
    @Override
    public String toString() {
        return "Movie{" +
                "duration='" + duration + '\'' +
                ", imdbId='" + imdbId + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", awards='" + awards + '\'' +
                '}';
    }





}

