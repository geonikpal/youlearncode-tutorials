package com.youlearncode.transactionalAnnotation.rollback.setup;

import com.youlearncode.transactionalAnnotation.Car;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("rollback")
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void demonstrateRollback(Car car) throws Exception {
        carRepository.demonstrateRollback(car);
    }
}
