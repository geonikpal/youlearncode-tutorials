package com.youlearncode.springbootcache.controller;

import com.youlearncode.springbootcache.model.Car;
import com.youlearncode.springbootcache.service.CarService;
import com.youlearncode.springbootcache.service.CarServiceWithoutAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Rest Controller for cars
 */
@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarRestController {

    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }


    @GetMapping(params = {"minPrice", "maxPrice"})
    public List<Car> getAllFilteredByPrice(
            @RequestParam Double minPrice,
            @RequestParam Double maxPrice
    ){
        return carService.getCarsWithPriceFilter(minPrice, maxPrice);
    }

    @GetMapping(params = {"brand"})
    public List<Car> getAllFilteredByBrand(
            @RequestParam String brand
    ){
        return carService.getCarsWithBrandFilter(brand);
    }

    @GetMapping("/evictAllBrandFilterCache")
    public void evictAllBrandFilterCache(){
        carService.evictAllBrandCacheEntries();
    }

    @GetMapping(value = "/evictBrandFilterCache", params = "brands")
    public void evictBrandFilterCache(@RequestParam List<String> brands){
        brands.forEach(carService::evictSpecificCaches);
    }

    @GetMapping(value = "/updateBrandFilterCache", params = "brands")
    public void updateBrandFilterCache(@RequestParam List<String> brands){
        brands.forEach(carService::putBrandFilterCache);
    }

    @PostMapping
    public Car create(@RequestBody Car car) {
        return carService.create(car);
    }



}