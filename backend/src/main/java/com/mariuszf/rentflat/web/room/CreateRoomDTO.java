package com.mariuszf.rentflat.web.room;

public class CreateRoomDTO {

    private double size;
    private int peopleAmount;
    private double cost;
    private Long flatId;

    public CreateRoomDTO(double size, int peopleAmount, double cost, Long flatId) {
        this.size = size;
        this.peopleAmount = peopleAmount;
        this.cost = cost;
        this.flatId = flatId;
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

    public Long getFlatId() {
        return this.flatId;
    }
}
