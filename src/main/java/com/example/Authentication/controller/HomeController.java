package com.example.Authentication.controller;

import com.example.Authentication.model.User;
import com.example.Authentication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private UserService service;

    @GetMapping({"/","home"})
    public String home(){
        return "Home";
    }
    @GetMapping("users")
    public List<User> getUsers(){
        return service.getUsers();
    }
    @PostMapping("users")
    public String saveUser(@RequestBody User user){
        service.save(user);
        return "Success";
    }
    @GetMapping("users/{username}")
    public User findUser(@PathVariable String username){
        return service.findByUserName(username);
    }
}