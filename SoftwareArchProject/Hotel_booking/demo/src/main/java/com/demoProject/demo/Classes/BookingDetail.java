package com.demoProject.demo.Classes;

public class BookingDetail {

    private String roomType;

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    private String hotelName;

    private Integer bhk;

    public String getFoodPlan() {
        return foodPlan;
    }

    public void setFoodPlan(String foodPlan) {
        this.foodPlan = foodPlan;
    }

    private String foodPlan;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Integer getBhk() {
        return bhk;
    }

    public void setBhk(Integer bhk) {
        this.bhk = bhk;
    }
}
