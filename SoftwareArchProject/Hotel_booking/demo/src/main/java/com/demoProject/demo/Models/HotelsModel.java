package com.demoProject.demo.Models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Hotels")
public class HotelsModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelOwnerName() {
        return hotelOwnerName;
    }

    public void setHotelOwnerName(String hotelOwnerName) {
        this.hotelOwnerName = hotelOwnerName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    public void setHotelPhoneNumber(String hotelPhoneNumber) {
        this.hotelPhoneNumber = hotelPhoneNumber;
    }

    public int getTotalNumberOfRooms() {
        return totalNumberOfRooms;
    }

    public void setTotalNumberOfRooms(int totalNumberOfRooms) {
        this.totalNumberOfRooms = totalNumberOfRooms;
    }

    public int getCurrentAvailableRooms() {
        return currentAvailableRooms;
    }

    public void setCurrentAvailableRooms(int currentAvailableRooms) {
        this.currentAvailableRooms = currentAvailableRooms;
    }

    @Column(name = "hotelId", nullable = false)
    private String hotelId;

    @Column(name = "hotelName", nullable = false)
    private String hotelName;

    @Column(name = "hotelOwnerName", nullable = false)
    private String hotelOwnerName;

    @Column(name = "hotelLocation", nullable = false)
    private String hotelLocation;

    @Column(name = "availableDate", nullable = false)
    private Date availableDate;

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    @Column(name = "hotelPhoneNumber", nullable = false)
    private String hotelPhoneNumber;

    @Column(name = "totalNumberOfRooms", nullable = false)
    private int totalNumberOfRooms;
    @Column(name = "currentAvailableRooms", nullable = false)
    private int currentAvailableRooms;



}



