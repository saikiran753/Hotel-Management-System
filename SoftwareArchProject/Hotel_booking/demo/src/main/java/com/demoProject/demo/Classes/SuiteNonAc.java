package com.demoProject.demo.Classes;

public class SuiteNonAc implements RoomBuilder{
    private Room room;

    public SuiteNonAc(){
        this.room = new Room();
    }
    @Override
    public void buildAc() {
        room.setAc(false);
    }

    @Override
    public void buildView() {
        room.setView("no balcony");

    }

    @Override
    public void buildTV() {
        room.setTelevision("no television");
    }

    @Override
    public void buildBHK(int n) {
        room.setBHK(n);
    }

    @Override
    public void buildFoodPlan(String f) {
        room.setFoodPlan("no food plan" );
    }

    @Override
    public Room getRoom() {
        return this.room;
    }
}
