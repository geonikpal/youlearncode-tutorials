package com.codelearnhub.springbootrestcontrollertutorial.controller;

import com.codelearnhub.springbootrestcontrollertutorial.model.Car;
import com.codelearnhub.springbootrestcontrollertutorial.service.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Rest Controller for cars
 */
@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CarRestController {

    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAll() {
        return carService.getAllCars();
    }

    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Car> getAllFilteredByPrice(
            @RequestParam @Positive(message = "minPrice parameter must be greater than zero") Double minPrice,
            @RequestParam @Positive(message = "maxPrice parameter must be greater than zero") Double maxPrice
    ){
        return carService.getCarsWithPriceFilter(minPrice, maxPrice);
    }

    @GetMapping("/{id}")
    public Car getById(@PathVariable @Positive(message = "id must be a positive number") Long id){
       return carService.getById(id);
    }

    @PostMapping
    public Car create(@Valid @RequestBody Car car) {
        return carService.create(car);
    }

    @PutMapping("/{id}")
    public Car update(@RequestBody @Valid Car car, @PathVariable @Positive(message = "id must be a positive number") Long id){
        return carService.update(id, car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") @Positive(message = "id must be a positive number") Long id) {
        carService.delete(id);
    }

}
