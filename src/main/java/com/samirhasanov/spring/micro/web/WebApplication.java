/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.micro.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Hasanov (Asus)
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false)
public class WebApplication {
    private static final String USER_SERVICE_URL = "http://USER-SERVICE";
    private static final String CAR_SERVICE_URL = "http://CAR-SERVICE";
    
    public static void main(String[] args) {
        System.out.println("Starting Web service");
        System.setProperty("spring.config.name", "web-service");
        
        SpringApplication.run(WebApplication.class, args);
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public WebService webService() {
        return new WebService(USER_SERVICE_URL, CAR_SERVICE_URL, restTemplate());
    }
    
    @Bean
    public WebController webController() {
        return new WebController(webService());
    }
}
