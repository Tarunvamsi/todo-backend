package com.vamsi.todo.controller;

import com.vamsi.todo.domain.User;
import com.vamsi.todo.model.CreateUserRequest;
import com.vamsi.todo.repository.UserRepository;
import com.vamsi.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public User createUser(@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }


    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

}
