package com.pluralsight.mvcdemo.controllers;

import com.pluralsight.mvcdemo.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute ("registration")Registration registration) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addRegistration(@Valid @ModelAttribute ("registration")Registration registration,
                                  BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("The submitted form has errors");
            return "registration";
        }
        System.out.println("Registration: " + registration.getName());
        // To implement post-redirect-get pattern useful for form registrations
        return "redirect:registration";
    }
}
