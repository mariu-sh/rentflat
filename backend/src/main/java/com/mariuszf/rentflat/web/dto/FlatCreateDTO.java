package com.mariuszf.rentflat.web.dto;

import javax.validation.constraints.NotNull;

public class FlatCreateDTO {

    @NotNull private final Double cost;
    @NotNull private final Double surface;

    public FlatCreateDTO(@NotNull Double cost, @NotNull Double surface) {
        this.cost = cost;
        this.surface = surface;
    }

    public Double getCost() {
        return cost;
    }

    public Double getSurface() {
        return surface;
    }
}
