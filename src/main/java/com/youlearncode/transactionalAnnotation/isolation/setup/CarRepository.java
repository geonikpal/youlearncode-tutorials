package com.youlearncode.transactionalAnnotation.isolation.setup;


import com.youlearncode.transactionalAnnotation.Car;

public interface CarRepository {

    void demonstrateIsolationType(Car car) throws Exception;

}
