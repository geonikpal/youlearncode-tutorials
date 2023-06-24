package com.youlearncode.transactionalAnnotation.isolation.setup;

import com.youlearncode.transactionalAnnotation.Car;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("isolation")
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public void demonstrateIsolationType(Car car) throws Exception {
        carRepository.demonstrateIsolationType(car);
    }
}
