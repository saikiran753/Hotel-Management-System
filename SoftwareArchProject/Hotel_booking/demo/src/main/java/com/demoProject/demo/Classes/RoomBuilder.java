package com.demoProject.demo.Classes;

public interface RoomBuilder {
    abstract void buildAc();

    public void buildView();

    public void buildTV();

    public void buildBHK(int n);

    public void buildFoodPlan(String f);

    public Room getRoom();
}
