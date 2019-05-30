package com.stackroute.springJdbc.domain;

public class Movie {
    private String moviename;
    private String movieid;
    private float rating;
    private int year;



    public Movie() {
    }

    public Movie(String moviename, String movieid, float rating,int year) {
        this.moviename = moviename;
        this.movieid = movieid;
        this.rating = rating;
        this.year=year;
    }

    public String getMoviename() {
        return moviename;
    }

    public void setMoviename(String moviename) {
        this.moviename = moviename;
    }

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" + "moviename='" + moviename + '\'' + ", movieid='" + movieid + '\'' + ", rating=" + rating + ", year=" + year + '}';
    }

}



