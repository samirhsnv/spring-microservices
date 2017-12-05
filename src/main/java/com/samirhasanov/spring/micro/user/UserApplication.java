package com.samirhasanov.spring.micro.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserApplication {

    public static void main(String[] args) {
        System.out.println("Starting User service");
        System.setProperty("spring.config.name", "user-service");
        SpringApplication.run(UserApplication.class, args);
    }
}
