package com.youlearncode.springbootcache.model;

import java.util.Objects;

public class Car {

    private Long id;
    private String model;
    private String brand;
    private Integer horses;
    private Double price;

    public Car() {
    }

    public Car(Long id, String model, String brand, Integer horses, Double price) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.horses = horses;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getHorses() {
        return horses;
    }

    public void setHorses(Integer horses) {
        this.horses = horses;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(model, car.model) && Objects.equals(brand, car.brand) && Objects.equals(horses, car.horses) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, brand, horses, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", horses=" + horses +
                ", price=" + price +
                '}';
    }
}