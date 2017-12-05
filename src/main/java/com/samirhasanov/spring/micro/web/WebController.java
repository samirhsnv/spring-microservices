/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.micro.web;

import com.samirhasanov.spring.micro.car.Car;
import com.samirhasanov.spring.micro.user.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WebController {
    private final WebService webService;
    
    @Autowired
    public WebController(WebService webService) {
        this.webService = webService;
    }
    
    @GetMapping("/users")
    protected List<User> getAllUsers() {
        return this.webService.getAllUsers();
    }
    
    @GetMapping("/users/{id}")
    protected User getUserById(@PathVariable Long id) {
        return this.webService.getUserById(id);
    }
    
    @GetMapping("/cars")
    protected List<Car> getAllCars() {
        return this.webService.getAllCars();
    }
    
    @GetMapping("/users/{id}/cars")
    protected List<Car> getCarsByOwnerId(@PathVariable Long id) {
        return this.webService.getCarsByOwnerId(id);
    }
    
    @GetMapping("/users/{userId}/cars/{id}")
    protected Car getCarByOwnerIdAndCarId(@PathVariable("userId") Long userId,
                                          @PathVariable("id") Long carId) {
        return this.webService.getCarByOwnerIdAndCarId(userId, carId);
    }
}
