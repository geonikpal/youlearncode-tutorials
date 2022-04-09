package com.codelearnhub.springbootrestcontrollertutorial.service;

import com.codelearnhub.springbootrestcontrollertutorial.model.Car;
import java.util.List;

public interface CarService {

    /**
     * Retrieves all cars currently existing
     * @return
     */
    List<Car> getAllCars();

    /**
     *
     * @param min The minimum price inclusive
     * @param max The maximum price exclusive
     * @return A list of cars with price inside [min, max]
     */
    List<Car> getCarsWithPriceFilter(Double min, Double max);

    /**
     *
     * @param id The id of the car
     * @return The car with the matching id
     */
    Car getById(Long id);

    /**
     *
     * @param The car object to be created
     * @return The car object that was created
     */
    Car create(Car car);

    /**
     *
     * @param id The id of the car to be updated
     * @param carRequest The car object to be updated
     * @return The updated car
     */
    Car update(Long id, Car carRequest);

    /**
     *
     * @param id The id of the car to be deleted
     */
    void delete(Long id);
}
