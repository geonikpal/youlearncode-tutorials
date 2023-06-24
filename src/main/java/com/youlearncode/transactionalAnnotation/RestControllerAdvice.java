package com.youlearncode.transactionalAnnotation;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {

    private final JdbcTemplate jdbcTemplate;

    public RestControllerAdvice(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public void carInsertError() {
        var count = jdbcTemplate.queryForObject("select count(id) from car", new SingleColumnRowMapper<>());
        System.out.println("Number of cars in db: " + count);

    }
}
