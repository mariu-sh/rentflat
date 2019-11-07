package com.mariuszf.rentflat.web.dto;

import javax.validation.constraints.NotNull;

public class RoomCreateDTO {

    @NotNull private final Double surface;
    @NotNull private final Long flatId;

    public RoomCreateDTO(@NotNull Double surface, @NotNull Long flatId) {
        this.surface = surface;
        this.flatId = flatId;
    }

    public Double getSurface() {
        return surface;
    }

    public Long getFlatId() {
        return flatId;
    }
}
