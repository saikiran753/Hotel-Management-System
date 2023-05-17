package com.demoProject.demo.Classes;

public class Twobhk extends TypeDecorator {
    RoomBook roombook;

    public Twobhk(RoomBook roombook) {
        this.roombook = roombook;
    }

    public String getDescription() {
        return this.roombook.getDescription() + ", with Two bedrooms";
    }

    public double cost() {
        return 31.9 + this.roombook.cost();
    }
}
