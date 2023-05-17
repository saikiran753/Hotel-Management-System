package com.demoProject.demo.Classes;

public class SuiteAc implements RoomBuilder{
    private Room room;

    public SuiteAc(){
        this.room = new Room();
    }
    @Override
    public void buildAc() {
        room.setAc(true);
    }

    @Override
    public void buildView() {
        room.setView("Road View With Balcony");

    }

    @Override
    public void buildTV() {
        room.setTelevision("LED Television");
    }

    @Override
    public void buildBHK(int n) {
        room.setBHK(n);
    }

    @Override
    public void buildFoodPlan(String f) {
        room.setFoodPlan("Only break fast " + f);
    }

    @Override
    public Room getRoom() {
        return this.room;
    }
}
