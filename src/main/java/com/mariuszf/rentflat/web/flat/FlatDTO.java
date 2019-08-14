package com.mariuszf.rentflat.web.flat;

public class FlatDTO {

    private final long id;
    private final double cost;
    private final double totalSurface;
    private final int roomsAmount;

    public FlatDTO(long id, double cost, double totalSurface, int roomsAmount) {
        this.id = id;
        this.cost = cost;
        this.totalSurface = totalSurface;
        this.roomsAmount = roomsAmount;
    }

    public long getId() {
        return id;
    }

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
