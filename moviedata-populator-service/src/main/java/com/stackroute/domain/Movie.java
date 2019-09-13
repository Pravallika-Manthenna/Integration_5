package com.stackroute.domain;

import java.util.List;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Movie {

    @CsvBindByName(column = "title")
    private String title;
    @CsvBindByName(column = "releaseDate")
    private String releaseDate;
    @CsvBindByName(column = "genre")
    private String genre;
    @CsvBindByName(column = "releaseYear")
    private String releaseYear;
    @CsvBindByName(column = "director")
    private String director;
    @CsvBindByName(column = "writer")
    private List<String> writer;
    @CsvBindByName(column = "actor")
    private List<String> actor;
    @CsvBindByName(column = "summary")
    private String summary;
    @CsvBindByName(column = "rated")
    private String rated;
    @CsvBindByName(column = "rating")
    private List<Rating> rating;
    @CsvBindByName(column = "language")
    private String language;
    @CsvBindByName(column = "duration")
    private String duration;
    @CsvBindByName(column = "awards")
    private String awards;
    @CsvBindByName(column = "ibdbId")
    private String ibdbId;
    @CsvBindByName(column = "production")
    private String production;
    @CsvBindByName(column = "country")
    private String country;
    @CsvBindByName(column = "poster")
    private String poster;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getWriter() {
        return writer;
    }

    public void setWriter(List<String> writer) {
        this.writer = writer;
    }

    public List<String> getActor() {
        return actor;
    }

    public void setActor(List<String> actor) {
        this.actor = actor;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getIbdbId() {
        return ibdbId;
    }

    public void setIbdbId(String ibdbId) {
        this.ibdbId = ibdbId;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public Movie(String title, String releaseDate, String genre, String releaseYear, String director, List<String> writer, List<String> actor, String summary, String rated, List<Rating> rating, String language, String duration, String awards, String ibdbId, String production, String country, String poster) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.director = director;
        this.writer = writer;
        this.actor = actor;
        this.summary = summary;
        this.rated = rated;
        this.rating = rating;
        this.language = language;
        this.duration = duration;
        this.awards = awards;
        this.ibdbId = ibdbId;
        this.production = production;
        this.country = country;
        this.poster = poster;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", director='" + director + '\'' +
                ", writer=" + writer +
                ", actor=" + actor +
                ", summary='" + summary + '\'' +
                ", rated='" + rated + '\'' +
                ", rating=" + rating +
                ", language='" + language + '\'' +
                ", duration='" + duration + '\'' +
                ", awards='" + awards + '\'' +
                ", ibdbId='" + ibdbId + '\'' +
                ", production='" + production + '\'' +
                ", country='" + country + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }
}
