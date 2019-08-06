package com.mariuszf.rentflat.web;

public class FlatDTO {

    private final int cost;
    private final double totalSurface;
    private final int roomsAmount;

    public FlatDTO(int cost, double totalSurface, int roomsAmount) {
        this.cost = cost;
        this.totalSurface = totalSurface;
        this.roomsAmount = roomsAmount;
    }

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
