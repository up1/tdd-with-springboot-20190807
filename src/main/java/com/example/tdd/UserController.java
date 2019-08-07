package com.example.tdd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable int id) {
        // TODO
        UserResponse userResponse = new UserResponse();
        userResponse.setId(1);
        userResponse.setName("somkiat");
        userResponse.setEmail("somkiat.p@gmail.com");
        return userResponse;
    }

}
