/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samirhasanov.spring.micro.user;

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
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {
    private final Map<Long, User> users = new HashMap<>();
    
    @PostConstruct
    public void init() {
        users.put(1L, new User(1L, "Samir Hasanov", 28));
        users.put(2L, new User(2L, "Murad Rzayev", 28));
        users.put(3L, new User(3L, "Bayram Gafarli", 27));
        users.put(4L, new User(4L, "Ziyatay Akbarli", 27));
        users.put(5L, new User(5L, "Javid Ismailov", 28));
    }
    
    @GetMapping
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }
    
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return users.get(id);
    }
}
