package com.youlearncode.transactionalAnnotation.rollback.setup;


import com.youlearncode.transactionalAnnotation.Car;

public interface CarRepository {

    void demonstrateRollback(Car car) throws Exception;

}
