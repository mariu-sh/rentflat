package com.mariuszf.rentflat.web.room;

public class UpdateRoomDTO {

    private double size;
    private int peopleAmount;
    private double cost;

    public UpdateRoomDTO(double size, int peopleAmount, double cost) {
        this.size = size;
        this.peopleAmount = peopleAmount;
        this.cost = cost;
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
