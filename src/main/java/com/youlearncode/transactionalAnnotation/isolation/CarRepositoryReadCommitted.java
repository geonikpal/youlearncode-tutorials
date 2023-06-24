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
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Repository
@Profile("readcommitted & isolation")
public class CarRepositoryReadCommitted extends AbstractCarRepository implements CarRepository {

    @Autowired
    public CarRepositoryReadCommitted(JdbcTemplate jdbcTemplate, ApplicationContext applicationContext) {
        super(jdbcTemplate, applicationContext);
    }

    @Transactional
    public void demonstrateIsolationType(Car car) throws Exception {
        jdbcTemplate.update(
                "INSERT INTO car(id, model, brand, horsepower, price) values (?,?,?,?,?)",
                car.getId(), car.getModel(), car.getBrand(), car.getHorsePower(), car.getPrice()
        );
        var bean = applicationContext.getBean("carRepositoryReadCommitted", CarRepositoryReadCommitted.class);
        bean.printNumberOfCars();
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public void printNumberOfCars() throws Exception {
        System.out.println("Current Transaction: " + TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Is active? " + TransactionSynchronizationManager.isActualTransactionActive());
        var count = jdbcTemplate.queryForObject("select count(id) from car", new SingleColumnRowMapper<>());
        System.out.println("Number of cars in db: " + count);
    }

}
