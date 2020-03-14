package com.mariuszf.rentflat.web.dto;

import javax.validation.constraints.NotNull;

public class RoomUpdateDTO {

    @NotNull private final Long id;
    @NotNull private final Double surface;

    public RoomUpdateDTO(@NotNull Long id, @NotNull Double surface) {
        this.id = id;
        this.surface = surface;
    }

    public Long getId() {
        return id;
    }

    public Double getSurface() {
        return surface;
    }
}
