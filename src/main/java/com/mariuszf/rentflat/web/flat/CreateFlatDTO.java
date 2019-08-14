package com.mariuszf.rentflat.web.flat;

public class CreateFlatDTO {
    private double cost;
    private double totalSurface;
    private int roomsAmount;

    public double getCost() {
        return cost;
    }

    public double getTotalSurface() {
        return totalSurface;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }
}
