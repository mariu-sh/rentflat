package com.mariuszf.rentflat.web.dto;

public class RoomCostDTO {

    private final long id;
    private final double cost;

    public RoomCostDTO(long id, double cost) {
        this.id = id;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }
}
