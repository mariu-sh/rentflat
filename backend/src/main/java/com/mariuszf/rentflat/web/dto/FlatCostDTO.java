package com.mariuszf.rentflat.web.dto;

import java.util.List;

public class FlatCostDTO {

    private final Long id;
    private final double cost;
    private final double calculatedCost;
    private final List<RoomCostDTO> rooms;

    public FlatCostDTO(Long id, double cost, List<RoomCostDTO> rooms) {
        this.id = id;
        this.cost = cost;
        this.rooms = rooms;
        this.calculatedCost = summarizeRoomsCost();
    }

    private double summarizeRoomsCost() {
        return rooms.stream().mapToDouble(RoomCostDTO::getCost).sum();
    }

    public Long getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public List<RoomCostDTO> getRooms() {
        return rooms;
    }

    public double getCalculatedCost() {
        return calculatedCost;
    }
}
