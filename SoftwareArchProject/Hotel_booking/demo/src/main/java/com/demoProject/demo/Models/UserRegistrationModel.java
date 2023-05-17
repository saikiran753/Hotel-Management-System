package com.demoProject.demo.Models;


import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "UserDetails")
public class UserRegistrationModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NonNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    public String getBookingHistory() {
        return bookingHistory;
    }

    public void setBookingHistory(String bookingHistory) {
        this.bookingHistory = bookingHistory;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Column(name = "firstName",nullable = false)
    @NonNull
    private String firstName;

    @Column(name = "lastName",nullable = false)
    @NonNull
    private String lastName;

    @Column(name = "phoneNumber", nullable = false,unique = true)
    @NonNull
    private String phoneNumber;
    @Column(name = "email",nullable = false, unique = true)
    @NonNull
    private String email;

    @Column(name = "bookingHistory")
    private String bookingHistory;

    @Column(name="passWord",nullable = false)
    private String passWord;


    @NonNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NonNull String userName) {
        this.userName = userName;
    }

    @Column(name="userName",nullable = false,unique = true)
    @NonNull
    private String userName;


}
