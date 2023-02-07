package com.pwdcrud.springbootcrudjdbc.controller;

import com.pwdcrud.springbootcrudjdbc.repository.UserRepository;
import com.pwdcrud.springbootcrudjdbc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        return userRepository.saveUser(user);
    }

    @PutMapping ("/user/update")
    public User updateUser(@RequestBody User user) {
        return userRepository.upadaterUser(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id) {
        return userRepository.getById(id);
    }
    @GetMapping("users")
    public List<User> allUser() {
        return userRepository.allUsers();
    }
}