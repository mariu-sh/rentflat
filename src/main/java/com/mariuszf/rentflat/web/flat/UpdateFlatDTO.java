package com.mariuszf.rentflat.web.flat;

public class UpdateFlatDTO {

    private final double cost;
    private final double totalSurface;
    private final int roomsAmount;

    public UpdateFlatDTO(int cost, double totalSurface, int roomsAmount) {
        this.cost = cost;
        this.totalSurface = totalSurface;
        this.roomsAmount = roomsAmount;
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
