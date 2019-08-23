package com.mariuszf.rentflat.web.flat.dto;

import com.mariuszf.rentflat.web.room.dto.RoomCostDTO;

import java.util.List;

public class FlatCostDTO {

    private final Long id;
    private final double cost;
    private final List<RoomCostDTO> rooms;

    public FlatCostDTO(Long id, double cost, List<RoomCostDTO> rooms) {
        this.id = id;
        this.cost = cost;
        this.rooms = rooms;
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
}
