package com.mariuszf.rentflat.web.flat;

import com.mariuszf.rentflat.web.room.RoomDTO;

import java.util.List;

public class FlatDTO {

    private final long id;
    private final double cost;
    private final double totalSurface;
    private final int roomsAmount;
    private final List<RoomDTO> rooms;

    public FlatDTO(long id, double cost, double totalSurface, int roomsAmount, List<RoomDTO> rooms) {
        this.id = id;
        this.cost = cost;
        this.totalSurface = totalSurface;
        this.roomsAmount = roomsAmount;
        this.rooms = rooms;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
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
