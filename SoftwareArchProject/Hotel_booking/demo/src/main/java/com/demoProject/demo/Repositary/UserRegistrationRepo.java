package com.demoProject.demo.Repositary;

import com.demoProject.demo.Models.UserRegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRegistrationRepo extends JpaRepository<UserRegistrationModel,Long> {
    Optional<UserRegistrationModel> findByuserName(String usernName);
}
