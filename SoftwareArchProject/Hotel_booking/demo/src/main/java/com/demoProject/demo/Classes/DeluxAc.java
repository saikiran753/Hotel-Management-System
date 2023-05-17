package com.demoProject.demo.Classes;

public class DeluxAc implements RoomBuilder{

    private Room room;

    public DeluxAc(){
        this.room = new Room();
    }
    @Override
    public void buildAc() {
       room.setAc(true);
    }

    @Override
    public void buildView() {
        room.setView("Beach View With Balcony");

    }

    @Override
    public void buildTV() {
    room.setTelevision("4K OLED with HomeTheater");
    }

    @Override
    public void buildBHK(int n) {
            room.setBHK(n);
    }

    @Override
    public void buildFoodPlan(String f) {
         room.setFoodPlan("Whole day " + f);
    }

    @Override
    public Room getRoom() {
        return this.room;
    }
}
