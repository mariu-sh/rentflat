package com.mariuszf.rentflat.web.room;

import com.mariuszf.rentflat.buisness.room.RoomEntity;

public class RoomDTO {

    private final long id;
    private double size;
    private int peopleAmount;
    private double cost;

    public RoomDTO(long id, double size, int peopleAmount, double cost) {
        this.id = id;
        this.size = size;
        this.peopleAmount = peopleAmount;
        this.cost = cost;
    }

    public long getId() {
        return id;
    }

    public double getSize() {
        return size;
    }

    public int getPeopleAmount() {
        return peopleAmount;
    }

    public double getCost() {
        return cost;
    }
}
