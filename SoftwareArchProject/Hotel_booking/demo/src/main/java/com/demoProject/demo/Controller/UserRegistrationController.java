package com.demoProject.demo.Controller;


import com.demoProject.demo.Models.LoginModel;
import com.demoProject.demo.Models.UserRegistrationModel;
import com.demoProject.demo.services.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account")
public class UserRegistrationController {

    private UserRegistrationService userRegistrationService;

    @Autowired
    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    @PostMapping
    @RequestMapping("/register")
    public UserRegistrationModel saveUser(@RequestBody UserRegistrationModel newUser){


        return userRegistrationService.addNewUser(newUser);

    }

    @GetMapping
    @RequestMapping("/all")
    public List<UserRegistrationModel> getAll(){

        return userRegistrationService.getAll();

    }


//    @PostMapping
//    @RequestMapping("/login")
//    public LoginModel isValidUser(@RequestBody LoginModel newUser){
//
//        return userRegistrationService.isValidUser(newUser);
//
//    }
}
