package com.mariuszf.rentflat.flatroomcrud.web.dto;

import javax.validation.constraints.NotNull;

public class FlatUpdateDTO {

    @NotNull private final Long id;
    @NotNull private final Double cost;
    @NotNull private final Double surface;

    public FlatUpdateDTO(@NotNull Long id, @NotNull Double cost, @NotNull Double surface) {
        this.id = id;
        this.cost = cost;
        this.surface = surface;
    }

    public Long getId() {
        return id;
    }

    public Double getCost() {
        return cost;
    }

    public Double getSurface() {
        return surface;
    }
}
