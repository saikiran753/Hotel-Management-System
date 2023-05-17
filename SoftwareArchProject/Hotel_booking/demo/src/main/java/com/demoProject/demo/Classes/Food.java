package com.demoProject.demo.Classes;

public class Food extends TypeDecorator {
    RoomBook roombook;

    public Food(RoomBook roombook) {
        this.roombook = roombook;
    }

    public String getDescription() {
        return this.roombook.getDescription() + ", with Food";
    }

    public double cost() {
        return 15.9 + this.roombook.cost();
    }
}
