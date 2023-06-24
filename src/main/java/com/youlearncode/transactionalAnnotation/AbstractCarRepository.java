package com.youlearncode.transactionalAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractCarRepository {

    protected final JdbcTemplate jdbcTemplate;
    protected final ApplicationContext applicationContext;

    public AbstractCarRepository(JdbcTemplate jdbcTemplate, ApplicationContext applicationContext) {
        this.jdbcTemplate = jdbcTemplate;
        this.applicationContext = applicationContext;
    }
}
