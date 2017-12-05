/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.micro.web;

import com.samirhasanov.spring.micro.car.Car;
import com.samirhasanov.spring.micro.user.User;
import java.util.Arrays;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Hasanov (Asus)
 */
@Service
public class WebService {
    
    private final RestTemplate restTemplate;
    private final String userServiceUrl;
    private final String carServiceUrl;
    
    public WebService(String userServiceUrl, String carServiceUrl, RestTemplate restTemplate) {
        this.userServiceUrl = userServiceUrl;
        this.carServiceUrl = carServiceUrl;
        this.restTemplate = restTemplate;
    }
    
    public List<User> getAllUsers() {
        ResponseEntity<User[]> users = restTemplate.getForEntity(userServiceUrl + "/users", User[].class);
        return Arrays.asList(users.getBody());
    }
    
    public User getUserById(Long id) {
        return restTemplate.getForObject(userServiceUrl + "/users/{id}", User.class, id);
    }
    
    public List<Car> getAllCars() {
        ResponseEntity<Car[]> cars = restTemplate.getForEntity(carServiceUrl + "/cars", Car[].class);
        return Arrays.asList(cars.getBody());
    }
    
    public List<Car> getCarsByOwnerId(Long ownerId) {
        ResponseEntity<Car[]> cars = restTemplate.getForEntity(carServiceUrl + "/cars/{ownerId}", Car[].class, ownerId);
        return Arrays.asList(cars.getBody());
    }
    
    public Car getCarByOwnerIdAndCarId(Long ownerId, Long carId) {
        return restTemplate.getForObject(carServiceUrl + "/cars/{ownerId}/{id}", Car.class, ownerId, carId);
    }
}
