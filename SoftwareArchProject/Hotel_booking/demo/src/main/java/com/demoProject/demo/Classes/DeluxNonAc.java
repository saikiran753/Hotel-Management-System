package com.demoProject.demo.Classes;

public class DeluxNonAc implements RoomBuilder{
    private Room room;

    public DeluxNonAc(){
        this.room = new Room();
    }
    @Override
    public void buildAc() {
        room.setAc(false);
    }

    @Override
    public void buildView() {
        room.setView("Beach View With Balcony");

    }

    @Override
    public void buildTV() {
        room.setTelevision("4K OLED ");
    }

    @Override
    public void buildBHK(int n) {
        room.setBHK(n);
    }

    @Override
    public void buildFoodPlan(String f) {
        room.setFoodPlan("Whole Day " + f);
    }

    @Override
    public Room getRoom() {
          return this.room;
    }
}
