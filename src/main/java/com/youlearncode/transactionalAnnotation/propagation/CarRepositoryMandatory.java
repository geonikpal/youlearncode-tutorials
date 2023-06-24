package com.youlearncode.transactionalAnnotation.propagation;

import com.youlearncode.transactionalAnnotation.AbstractCarRepository;
import com.youlearncode.transactionalAnnotation.Car;
import com.youlearncode.transactionalAnnotation.propagation.setup.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Repository
@Profile("propagation & mandatory")
public class CarRepositoryMandatory extends AbstractCarRepository implements CarRepository {

    @Autowired
    public CarRepositoryMandatory(JdbcTemplate jdbcTemplate, ApplicationContext applicationContext) {
        super(jdbcTemplate, applicationContext);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertCarAndUpdateCar(Car car) throws Exception {
        jdbcTemplate.update(
                "INSERT INTO car(id, model, brand, horsepower, price) values (?,?,?,?,?)",
                car.getId(), car.getModel(), car.getBrand(), car.getHorsePower(), car.getPrice()
        );
        var bean = ((CarRepositoryMandatory) applicationContext.getBean("carRepositoryMandatory"));
        bean.updateCar(car, 0.1);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateCar(Car car, double percent) throws Exception {
        System.out.println("Current Transaction: " + TransactionSynchronizationManager.getCurrentTransactionName());
        System.out.println("Is active? " + TransactionSynchronizationManager.isActualTransactionActive());
        jdbcTemplate.update(
                "UPDATE car set price = ? where id = ?",
                car.getPrice() * (1 + percent), car.getId()
        );
    }


}
