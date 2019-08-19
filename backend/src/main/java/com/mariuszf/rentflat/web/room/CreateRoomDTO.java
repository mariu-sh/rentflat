package com.mariuszf.rentflat.web.room;

public class CreateRoomDTO {

    private double surface;
    private double cost;
    private Long flatId;

    public CreateRoomDTO(double surface, double cost, Long flatId) {
        this.surface = surface;
        this.cost = cost;
        this.flatId = flatId;
    }

    public double getSurface() {
        return surface;
    }

    public double getCost() {
        return cost;
    }

    public Long getFlatId() {
        return flatId;
    }
}
