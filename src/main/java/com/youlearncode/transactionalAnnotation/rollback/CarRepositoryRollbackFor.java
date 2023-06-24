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

import java.io.FileNotFoundException;

@Repository
@Profile("rollback & rollbackfor")
public class CarRepositoryRollbackFor extends AbstractCarRepository implements CarRepository {

    @Autowired
    public CarRepositoryRollbackFor(JdbcTemplate jdbcTemplate, ApplicationContext applicationContext) {
        super(jdbcTemplate, applicationContext);
    }

    @Transactional(rollbackFor = FileNotFoundException.class )
    public void demonstrateRollback(Car car) throws FileNotFoundException {
        jdbcTemplate.update(
                "INSERT INTO car(model, b" +
                        "rand, horsepower, price) values (?,?,?,?)",
                car.getModel(), car.getBrand(), car.getHorsePower(), car.getPrice()
        );
        throw new FileNotFoundException("Just an iob exception");

    }

}
