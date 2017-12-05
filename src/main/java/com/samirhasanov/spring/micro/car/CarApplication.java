/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.micro.car;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 *
 * @author Hasanov (Asus)
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CarApplication {
    
    public static void main(String[] args) {
        System.out.println("Starting Car service");
        System.setProperty("spring.config.name", "car-service");
        SpringApplication.run(CarApplication.class, args);
    }
}
