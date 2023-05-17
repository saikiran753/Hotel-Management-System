package com.demoProject.demo.services;

import com.demoProject.demo.Models.UserRegistrationModel;
import com.demoProject.demo.Repositary.UserRegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRegistrationService {




    private UserRegistrationRepo userRegistrationRepo;


    @Autowired
    public UserRegistrationService(UserRegistrationRepo userRegistrationRepo) {
        this.userRegistrationRepo = userRegistrationRepo;

    }


    public UserRegistrationModel addNewUser(UserRegistrationModel  newUser){
        System.out.println(newUser);

        return this.userRegistrationRepo.save(newUser);
    }


    public List<UserRegistrationModel> getAll() {
        return this.userRegistrationRepo.findAll();
    }




}
