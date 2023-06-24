package com.youlearncode.transactionalAnnotation.isolation;

import com.youlearncode.transactionalAnnotation.AbstractCarRepository;
import com.youlearncode.transactionalAnnotation.Car;
import com.youlearncode.transactionalAnnotation.isolation.setup.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Profile("repeatableread & isolation")
public class CarRepositoryRepeatableRead extends AbstractCarRepository implements CarRepository {

    @Autowired
    public CarRepositoryRepeatableRead(JdbcTemplate jdbcTemplate, ApplicationContext applicationContext) {
        super(jdbcTemplate, applicationContext);
    }

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public void demonstrateIsolationType(Car car) throws Exception {
        jdbcTemplate.update(
                "INSERT INTO car(id, model, brand, horsepower, price) values (?,?,?,?,?)",
                car.getId(), car.getModel(), car.getBrand(), car.getHorsePower(), car.getPrice()
        );
        var priceBefore = jdbcTemplate.queryForObject("select price from car where id = 1", new SingleColumnRowMapper<>());
        System.out.println("Price of first  before: " + priceBefore);
        var bean = applicationContext.getBean("carRepositoryRepeatableRead", CarRepositoryRepeatableRead.class);
        bean.countCarsAndUpdateTheExisting();
        var priceAfter = jdbcTemplate.queryForObject("select price from car where id = 1", new SingleColumnRowMapper<>());

        System.out.println("Price of first  after: " + priceAfter);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
    public void countCarsAndUpdateTheExisting() throws Exception {
        jdbcTemplate.update("UPDATE car set price = 22000 where id = 1");
    }


}
