package com.stackroute.springJdbc.controller;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringJdbcController {
    @Autowired
    private SpringJdbcRepository springJdbcRepository;

    public ResponseEntity<String> executeShow() {
        Movie entity = springJdbcRepository.get("L-105");
        return new ResponseEntity("movie: " + entity.getMoviename()
                + ", " + entity.getMovieid()+", " + entity.getRating()+", " + entity.getYear(), HttpStatus.OK);
    }

    public ResponseEntity<String> insert() {
        Movie entity = new Movie("darling","s5",5,2010);
        /*Movie entity = new Movie("ben10","s3",5,2008);
        Movie entity = new Movie("majili","s4",4,2019);
        Movie entity = new Movie("darling","s6",5,2010);*/
        springJdbcRepository.add(entity);
        return new ResponseEntity("Movie Add: " + entity.getMoviename()
                + ", " + entity.getMovieid()+", " + entity.getRating()+", " + entity.getYear(), HttpStatus.OK);
    }

    public ResponseEntity<String> read() {
        Movie entity = springJdbcRepository.get("s1");
        return new ResponseEntity("Movie Get: " + entity.getMoviename()
                + ", " + entity.getMovieid()+", " + entity.getRating()+", " + entity.getYear(), HttpStatus.OK);
    }

    public ResponseEntity<String> update() {
        Movie entity = new Movie("araya","s2",3,2016);
        springJdbcRepository.update(entity);
        return new ResponseEntity("movie Update: " + entity.getMoviename()
                + ", " + entity.getMovieid() + ", " + entity.getRating()+ ", " + entity.getYear(),HttpStatus.OK);
    }

    public ResponseEntity<String> delete() {
        Movie entity = new Movie("araya", "s2",3,2016);
        springJdbcRepository.delete(entity);
        return new ResponseEntity("Movie Delete: " + entity.getMoviename()
                + ", " + entity.getMovieid()+", " + entity.getRating()+", " + entity.getYear(), HttpStatus.OK);
    }
    public ResponseEntity<?> getAll() {
        List<Movie> studentList =springJdbcRepository.getAll();
        return new ResponseEntity<List<Movie>>(studentList,HttpStatus.OK);
    }
}
