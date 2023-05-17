package com.demoProject.demo.Models;

import javax.persistence.*;

@Entity
public class BookingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;


    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBhk() {
        return bhk;
    }

    public void setBhk(int bhk) {
        this.bhk = bhk;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getTelevison() {
        return televison;
    }

    public void setTelevison(String televison) {
        this.televison = televison;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return CustomerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        CustomerPhoneNumber = customerPhoneNumber;
    }
    @Column(name = "hotelName",nullable = false)
    private String hotelName;
    @Column(name = "username",nullable = false)
    private String username;
    @Column(name = "bhk",nullable = false)
    private int bhk;
     @Column(name = "roomType",nullable = false)
    private String roomType;
    @Column(name = "televison",nullable = false)
    private String televison;
    @Column(name = "view",nullable = false)
    private String view;
    @Column(name = "food",nullable = false)
    private String food;
    @Column(name = "customerName",nullable = false)
    private String customerName;
    @Column(name = "CustomerPhoneNumber",nullable = false)
    private String CustomerPhoneNumber;
                    


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
