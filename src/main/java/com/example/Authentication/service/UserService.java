package com.example.Authentication.service;

import com.example.Authentication.model.User;
import com.example.Authentication.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
    public List<User> getUsers() {
        return repo.findAll();
    }

    public void save(User user) {
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        System.out.println(user.getUserPassword());
        repo.save(user);
    }
    public User findByUserName(String username){
        return repo.findByUserName(username);
    }
}
