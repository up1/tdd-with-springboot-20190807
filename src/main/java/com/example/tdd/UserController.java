package com.example.tdd;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserResponse userResponse = new UserResponse();
            userResponse.setId(user.get().getId());
            userResponse.setName(user.get().getName());
            userResponse.setEmail(user.get().getEmail());
            return userResponse;
        } 
        return new UserResponse();
    }

}
