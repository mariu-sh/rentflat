package com.mariuszf.rentflat.flatroomcrud.web.dto;

import javax.validation.constraints.NotNull;

public class RoomCostDTO {

    @NotNull private final Long id;
    @NotNull private final String uuid;
    @NotNull private final Double cost;

    public RoomCostDTO(@NotNull Long id, @NotNull String uuid, @NotNull Double cost) {
        this.id = id;
        this.uuid = uuid;
        this.cost = cost;
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
}
