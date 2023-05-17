package com.demoProject.demo.Classes;

public class Onebhk extends TypeDecorator {
    RoomBook roombook;

    public Onebhk(RoomBook roombook) {
        this.roombook = roombook;
    }

    public String getDescription() {
        return this.roombook.getDescription() + ", with one bedroom";
    }

    public double cost() {
        return 21.9 + this.roombook.cost();
    }
}
