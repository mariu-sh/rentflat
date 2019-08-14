package com.mariuszf.rentflat.web;

public class FlatDTO {

    private final long id;
    private final int cost;
    private final double totalSurface;
    private final int roomsAmount;

    public FlatDTO(long id, int cost, double totalSurface, int roomsAmount) {
        this.id = id;
        this.cost = cost;
        this.totalSurface = totalSurface;
        this.roomsAmount = roomsAmount;
    }

    public long getId() {
        return id;
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
