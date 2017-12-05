/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.micro.car;

/**
 *
 * @author Hasanov (Asus)
 */
public class Car {
    private Long id;
    private String brand;
    private String model;
    private Integer year;

    public Car() {
    }

    public Car(Long id, String brand, String model, Integer year) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", brand=" + brand + ", model=" + model + ", year=" + year + '}';
    }
}
