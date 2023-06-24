package com.youlearncode.transactionalAnnotation.propagation.setup;

import com.youlearncode.transactionalAnnotation.Car;

public interface CarRepository {

    void insertCarAndUpdateCar(Car car) throws Exception;

    void updateCar(Car car, double percent) throws Exception;

}
