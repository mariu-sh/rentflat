package com.mariuszf.rentflat.web.room;

public class UpdateRoomDTO {

    private double surface;
    private double cost;

    public UpdateRoomDTO(double surface, double cost) {
        this.surface = surface;
        this.cost = cost;
    }

    public double getSurface() {
        return surface;
    }

    public double getCost() {
        return cost;
    }
}
