package com.vamsi.todo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/greet")
    public String greet() {
        return "Hello!!!";
    }
}
