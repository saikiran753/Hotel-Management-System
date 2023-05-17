package com.demoProject.demo.Classes;

public class Ac extends TypeDecorator {
    RoomBook roombook;

    public Ac(RoomBook roombook) {
        this.roombook = roombook;
    }

    public String getDescription() {
        return this.roombook.getDescription() + ", with AC";
    }

    public double cost() {
        return 6.0 + this.roombook.cost();
    }
}
