package com.demoProject.demo.Classes;

public class MyHotelRoom {

    private RoomBuilder roomBuilder;

    public MyHotelRoom(RoomBuilder roomBuilder){
        this.roomBuilder = roomBuilder;
    }

    public Room getRoom(){
        return this.roomBuilder.getRoom();
    }

    public void bookMyRoom(int n, String f){
        this.roomBuilder.buildBHK(n);
        this.roomBuilder.buildFoodPlan(f);
        this.roomBuilder.buildAc();
        this.roomBuilder.buildTV();
        this.roomBuilder.buildView();
    }

}
