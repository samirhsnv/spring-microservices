/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.micro.main;

import com.samirhasanov.spring.micro.car.CarApplication;
import com.samirhasanov.spring.micro.eureka.EurekaApplication;
import com.samirhasanov.spring.micro.user.UserApplication;
import com.samirhasanov.spring.micro.web.WebApplication;

/**
 *
 * @author Hasanov (Asus)
 */
public class Main {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Select an application to run:");
            System.out.println("eureka - Eureka server");
            System.out.println("user - User service");
            System.out.println("car - Car service");
            System.out.println("web - Web service");
        }
        else {
            switch(args[0]) {
                case "eureka":
                    EurekaApplication.main(args);
                    break;
                    
                case "user":
                    if(args.length == 2) {
                        System.setProperty("server.port", args[1]);
                    }
                    
                    UserApplication.main(args);
                    break;
                    
                case "car":
                    if(args.length == 2) {
                        System.setProperty("server.port", args[1]);
                    }
                    
                    CarApplication.main(args);
                    break;
                    
                case "web":
                    if(args.length == 2) {
                        System.setProperty("server.port", args[1]);
                    }
                    
                    WebApplication.main(args);
                    break;
            }
        }
    }
}
