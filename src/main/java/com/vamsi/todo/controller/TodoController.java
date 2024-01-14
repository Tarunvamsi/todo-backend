package com.vamsi.todo.controller;

import com.vamsi.todo.domain.User;
import com.vamsi.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class TodoController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("todos")
    public List<User> getAllTodos() {
        return userRepository.findAll();
    }
}
