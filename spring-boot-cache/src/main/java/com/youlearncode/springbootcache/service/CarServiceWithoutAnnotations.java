package com.youlearncode.springbootcache.service;

import com.youlearncode.springbootcache.model.Car;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.interceptor.SimpleKey;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Profile("!default")
public class CarServiceWithoutAnnotations {

    @Qualifier("brandFilterCacheManager")
    private final CacheManager brandFilterCacheManager;

    @Qualifier("priceFilterCacheManager")
    private final CacheManager priceFilterCacheManager;

    private List<Car> cars = new ArrayList<>(
            List.of(
                    new Car(1L, "Astra", "Opel", 100, 18000d),
                    new Car(2L, "Insignia", "Opel", 120, 22000d),
                    new Car(3L, "Golf", "VW", 90, 17000d),
                    new Car(4L, "Golf", "VW", 120, 19000d),
                    new Car(5L, "Gallardo", "Lamborghini", 400, 100_000d)
            ));

    public CarServiceWithoutAnnotations(CacheManager brandFilterCacheManager, CacheManager priceFilterCacheManager) {
        this.brandFilterCacheManager = brandFilterCacheManager;
        this.priceFilterCacheManager = priceFilterCacheManager;
    }

    public List<Car> getCarsWithPriceFilter(Double min, Double max) {
        Cache cache = priceFilterCacheManager.getCache("priceFilterCache");
        var result = Optional
                .ofNullable(cache)
                .map(cache_ -> cache_.get(new SimpleKey(min, max)))
                .orElseGet(() -> insertInCacheAndReturn(min, max, cache))
                .get();
        return (List<Car>) result;
    }

    public List<Car> getCarsWithBrandFilter(String brand) {
        Cache cache = brandFilterCacheManager.getCache("brandFilterCache");
        var result = Optional
                .ofNullable(cache)
                .map(cache_ -> cache_.get(new SimpleKey(brand)))
                .orElseGet(() -> insertInCacheAndReturn(brand, cache))
                .get();
        return (List<Car>) result;
    }

    private Cache.ValueWrapper insertInCacheAndReturn(String brand, Cache cache) {
        return () -> {
            List<Car> resultToBePut = cars.stream()
                    .filter(car -> car.getBrand().equals(brand))
                    .toList();
            cache.put(new SimpleKey(brand), resultToBePut);
            return resultToBePut;
        };
    }

    private Cache.ValueWrapper insertInCacheAndReturn(Double min, Double max, Cache cache) {
        return () -> {
            List<Car> resultToBePut = cars.stream()
                    .filter(car -> car.getPrice() >= min && car.getPrice() <= max)
                    .toList();
            cache.put(new SimpleKey(min, max), resultToBePut);
            return resultToBePut;
        };
    }

    public void evictAllBrandCacheEntries() {
        brandFilterCacheManager.getCache("brandFilterCache").clear();
    }

    public void evictSpecificCaches(String brand) {
        brandFilterCacheManager.getCache("brandFilterCache").evictIfPresent(new SimpleKey(brand));
    }

    public void putBrandFilterCache(String brand) {
        Cache cache = brandFilterCacheManager.getCache("brandFilterCache");
        List<Car> resultToBePut = cars.stream()
                .filter(car -> car.getBrand().equals(brand))
                .toList();
        cache.put(new SimpleKey(brand), resultToBePut);
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