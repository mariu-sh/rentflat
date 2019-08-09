package com.mariuszf.rentflat.web;

public class RoomDTO {

    private double size;
    private int people;
    private double cost;

    public RoomDTO(double size, int people, double cost) {
        this.size = size;
        this.people = people;
        this.cost = cost;
    }

    public double getSize() {
        return size;
    }

    public int getPeople() {
        return people;
    }

    public double getCost() {
        return cost;
    }
}
