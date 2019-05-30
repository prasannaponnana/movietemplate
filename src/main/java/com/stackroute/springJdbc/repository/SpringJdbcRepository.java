package com.stackroute.springJdbc.repository;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.mapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SpringJdbcRepository {
    private JdbcTemplate jdbcTemplate ;

    public SpringJdbcRepository(){}


//    @Autowired
//    public void SpringJdbcRepository(final DataSource dataSource) {
//        this.jdbcTemplate.setDataSource(dataSource);
//    }
    @Autowired
    public void  setDataSource( DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAll() {
        return jdbcTemplate .query("select * from movie", new MovieRowMapper());
    }

//    public int add(final String  id, final String firstName) {
//        return jdbcTemplate.update("INSERT INTO STUDENT VALUES (?, ?)", id, firstName);
//    }

    public int add(Movie movie) {
        return jdbcTemplate.update("insert into movie values (?, ?, ?, ?)", movie.getMoviename(), movie.getMovieid(),movie.getRating(),movie.getYear());
    }

    public Movie get(String movieid) {
        final String query = "select * from movie where movieid = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { movieid }, new MovieRowMapper());
    }

    public int update(Movie entity) {
        return jdbcTemplate.update("update movie set moviename=? where movieid=?", entity.getMoviename(), entity.getMovieid());
    }


    public int delete(Movie entity) {
        return jdbcTemplate.update("delete from movie WHERE movieid=?", entity.getMovieid());
    }

}
