package com.mariuszf.rentflat.flatroomcrud.web.dto;

import javax.validation.constraints.NotNull;

public class FlatCreateDTO {

    @NotNull private Double cost;
    @NotNull private Double surface;

    public FlatCreateDTO(@NotNull Double cost, @NotNull Double surface) {
        this.cost = cost;
        this.surface = surface;
    }

    public FlatCreateDTO() {
    }

    public Double getCost() {
        return cost;
    }

    public Double getSurface() {
        return surface;
    }
}
