package com.mariuszf.rentflat.buisness;


public class FlatEntity {
    private int cost;
    private double totalSurface;
    private int roomsAmount;

    FlatEntity(int cost, double totalSurface, int roomsAmount) {
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
