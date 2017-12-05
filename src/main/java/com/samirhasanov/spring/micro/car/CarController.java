/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.micro.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Hasanov (Asus)
 */
@RestController
@RequestMapping(value = "/cars", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CarController {
    private final Map<Long, List<Car>> cars = new HashMap<>();
    
    @PostConstruct
    private void init() {
        List<Car> samirCars = new ArrayList<>();
        samirCars.add(new Car(1L, "Mercedes Benz", "E400 Coupe", 2017));
        samirCars.add(new Car(2L, "BMW", "M5", 2016));
        samirCars.add(new Car(3L, "Honda", "Accord", 2009));
        
        List<Car> muradCars = new ArrayList<>();
        muradCars.add(new Car(4L, "Mercedes Benz", "S550", 2015));
        muradCars.add(new Car(5L, "BMW", "550", 2018));
        muradCars.add(new Car(6L, "Lexus", "570", 2014));
        
        List<Car> bayramCars = new ArrayList<>();
        bayramCars.add(new Car(7L, "KIA", "Cerato", 2013));
        bayramCars.add(new Car(8L, "Mercedes Benz", "G550", 2017));
        
        List<Car> ziyaCars = new ArrayList<>();
        ziyaCars.add(new Car(9L, "Dodge", "Challenger SRT", 2017));
        ziyaCars.add(new Car(10L, "Ford", "Mustang Shelby GT500", 2012));
        
        cars.put(1L, samirCars);
        cars.put(2L, muradCars);
        cars.put(3L, bayramCars);
        cars.put(4L, ziyaCars);
    }
    
    @GetMapping
    protected List<Car> getAllCars() {
        List<Car> list = new ArrayList<>();
        
        cars.values().forEach((c) -> {
            list.addAll(c);
        });
        
        return list;
    }
    
    @GetMapping("/{ownerId}")
    protected List<Car> getCarsByOwner(@PathVariable Long ownerId) {
        return cars.get(ownerId);
    }
    
    @GetMapping("/{ownerId}/{id}")
    protected Car getCarById(@PathVariable("ownerId") Long ownerId,
                             @PathVariable("id") Long id) {
        
        for(Car c: cars.get(ownerId)) {
            if(c.getId() == id) {
                return c;
            }
        }
        
        return null;
    }
}
