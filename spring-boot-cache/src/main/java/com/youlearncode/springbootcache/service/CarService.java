package com.youlearncode.springbootcache.service;

import com.youlearncode.springbootcache.model.Car;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> cars = new ArrayList<>(
            List.of(
                    new Car(1L, "Astra", "Opel", 100, 18000d),
                    new Car(2L, "Insignia", "Opel", 120, 22000d),
                    new Car(3L, "Golf", "VW", 90, 17000d),
                    new Car(4L, "Golf", "VW", 120, 19000d),
                    new Car(5L, "Gallardo", "Lamborghini", 400, 100_000d)
            ));

    @Cacheable(value = "priceFilterCache",
            cacheResolver = "priceFilterCacheResolver",
            unless = "#result.size() == 2"
    )
    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
        return cars.stream()
                .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
                .toList();
    }

    @Cacheable(value = "brandFilterCache", cacheManager = "brandFilterCacheManager")
    public List<Car> getCarsWithBrandFilter(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .toList();
    }

    @CacheEvict(value = "brandFilterCache", cacheManager = "brandFilterCacheManager", allEntries = true)
    public void evictAllBrandCacheEntries() {}

    @CacheEvict(value = "brandFilterCache", cacheManager = "brandFilterCacheManager", key = "#brand")
    public void evictSpecificCaches(String brand) {}

    @CachePut(value = "brandFilterCache", cacheManager = "brandFilterCacheManager", key = "#brand")
    public List<Car> putBrandFilterCache(String brand) {
        return cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .toList();
    }

    public Car create(Car car) {
        Long newId = cars.stream().mapToLong(Car::getId).max().orElse(0L) + 1L;
        car.setId(newId);
        cars.add(car);
        return cars.stream()
                .filter(car_ -> car_.getId().equals(newId))
                .findAny()
                .orElseThrow();
    }

}