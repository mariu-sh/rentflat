package com.mariuszf.rentflat.web.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class FlatCostDTO {

    @NotNull private final Long id;
    @NotNull private final String uuid;
    @NotNull private final Double cost;
    @NotNull private final List<RoomCostDTO> rooms;

    public FlatCostDTO(@NotNull Long id, @NotNull String uuid, @NotNull Double cost, @NotNull List<RoomCostDTO> rooms) {
        this.id = id;
        this.uuid = uuid;
        this.cost = cost;
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public Double getCost() {
        return cost;
    }

    public List<RoomCostDTO> getRooms() {
        return rooms;
    }
}
