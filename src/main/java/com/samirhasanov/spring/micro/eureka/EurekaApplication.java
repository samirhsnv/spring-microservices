package com.samirhasanov.spring.micro.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // This will enable and run Eureka Discovery Server based on application.properties
public class EurekaApplication {

    // This application is something like car selling web app
    // Users add cars which they want to sell
    // We have different packages for users and cars, because these are microservices baby!
    
    public static void main(String[] args) {
        System.out.println("Starting Eureka server");
        SpringApplication.run(EurekaApplication.class, args);
    }
}
