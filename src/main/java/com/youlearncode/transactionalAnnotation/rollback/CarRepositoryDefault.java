package com.youlearncode.transactionalAnnotation.rollback;

import com.youlearncode.transactionalAnnotation.AbstractCarRepository;
import com.youlearncode.transactionalAnnotation.Car;
import com.youlearncode.transactionalAnnotation.rollback.setup.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Profile("rollback & defaultrollback")
public class CarRepositoryDefault extends AbstractCarRepository implements CarRepository {


    @Autowired
    public CarRepositoryDefault(JdbcTemplate jdbcTemplate, ApplicationContext applicationContext) {
        super(jdbcTemplate, applicationContext);
    }

    @Transactional
    public void demonstrateRollback(Car car) {
        jdbcTemplate.update(
                "INSERT INTO car(id, model, brand, horsepower, price) values (?, ?,?,?,?)",
                car.getId(), car.getModel(), car.getBrand(), car.getHorsePower(), car.getPrice()
        );
        throw new NullPointerException("Just a null pointer exception");

    }



}
