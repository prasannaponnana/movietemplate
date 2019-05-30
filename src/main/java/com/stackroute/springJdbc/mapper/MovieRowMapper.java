package com.stackroute.springJdbc.mapper;

import com.stackroute.springJdbc.domain.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow( ResultSet rs, int rowNum) throws SQLException {
         Movie movie = new Movie();
        movie.setMovieid(rs.getString("movieid"));
        movie.setMoviename(rs.getString("moviename"));
        movie.setRating(rs.getInt("rating"));
        movie.setYear(rs.getInt("year"));

        return movie;
    }
}
