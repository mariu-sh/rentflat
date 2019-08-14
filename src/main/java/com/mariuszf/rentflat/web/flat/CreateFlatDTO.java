package com.mariuszf.rentflat.web.flat;

public class CreateFlatDTO {
    private int cost;
    private double totalSurface;
    private int roomsAmount;

    public int getCost() {
        return cost;
    }

    public double getTotalSurface() {
        return totalSurface;
    }

    public int getRoomsAmount() {
        return roomsAmount;
    }
}
