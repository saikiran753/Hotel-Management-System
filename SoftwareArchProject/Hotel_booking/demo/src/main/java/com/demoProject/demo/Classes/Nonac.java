package com.demoProject.demo.Classes;

public class Nonac extends TypeDecorator {
    RoomBook roombook;

    public Nonac() {
    }

    public String getDescription() {
        return this.roombook.getDescription() + ", with NON-AC";
    }

    public double cost() {
        return 0.0 + this.roombook.cost();
    }
}

