package com.pluralsight.mvcdemo.controllers;

import com.pluralsight.mvcdemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser(@RequestParam(value="firstname", defaultValue = "Yannam") String firstName,
                     @RequestParam(value="lastname", defaultValue = "Govardhan") String lastName,
                     @RequestParam(value="age", defaultValue ="24") int age) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAge(age);
        return user;
    }

    @PostMapping("/user")
    public User postUser(User user) {
        return user;
    }
}
