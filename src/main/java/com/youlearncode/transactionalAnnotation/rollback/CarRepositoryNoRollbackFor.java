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
@Profile("rollback & norollbackfor")
public class CarRepositoryNoRollbackFor extends AbstractCarRepository implements CarRepository {

    @Autowired
    public CarRepositoryNoRollbackFor(JdbcTemplate jdbcTemplate, ApplicationContext applicationContext) {
        super(jdbcTemplate, applicationContext);
    }

    @Transactional(noRollbackFor = NullPointerException.class)
    public void demonstrateRollback(Car car) {
        jdbcTemplate.update(
                "INSERT INTO car(model, brand, horsepower, price) values (?,?,?,?)",
                car.getModel(), car.getBrand(), car.getHorsePower(), car.getPrice()
        );
        throw new NullPointerException("Null Pointer Exception");

    }
}
