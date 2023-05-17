package com.demoProject.demo.Classes;

public abstract class RoomBook {
    String description = "Book Room";

    public RoomBook() {
    }

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();
}
