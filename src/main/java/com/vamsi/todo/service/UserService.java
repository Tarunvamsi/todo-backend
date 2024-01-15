package com.vamsi.todo.service;

import com.vamsi.todo.domain.User;
import com.vamsi.todo.exception.NotFoundException;
import com.vamsi.todo.model.CreateUserRequest;
import com.vamsi.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(CreateUserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        return userRepository.save(user);
    }

    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found."));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
