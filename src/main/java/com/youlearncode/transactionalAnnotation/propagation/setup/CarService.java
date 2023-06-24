package com.youlearncode.transactionalAnnotation.propagation.setup;

import com.youlearncode.transactionalAnnotation.Car;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("propagation")
public class CarService {

    protected final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void insertAndUpdateCar(Car car) throws Exception {
        carRepository.insertCarAndUpdateCar(car);
    }
}
