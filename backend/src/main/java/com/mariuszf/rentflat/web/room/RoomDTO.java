package com.mariuszf.rentflat.web.room;

import com.mariuszf.rentflat.buisness.room.RoomEntity;

public class RoomDTO {

    private final long id;
    private double surface;
    private double cost;

    public RoomDTO(long id, double surface, double cost) {
        this.id = id;
        this.surface = surface;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public double getSurface() {
        return surface;
    }

    public double getCost() {
        return cost;
    }
}
