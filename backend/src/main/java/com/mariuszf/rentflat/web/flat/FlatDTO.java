package com.mariuszf.rentflat.web.flat;

import com.mariuszf.rentflat.web.room.RoomDTO;

import java.util.List;

public class FlatDTO {

    private final long id;
    private final double cost;
    private final double surface;
    private final List<RoomDTO> rooms;

    public FlatDTO(long id, double cost, double surface, List<RoomDTO> rooms) {
        this.id = id;
        this.cost = cost;
        this.surface = surface;
        this.rooms = rooms;
    }

    public long getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public double getSurface() {
        return surface;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }
}
