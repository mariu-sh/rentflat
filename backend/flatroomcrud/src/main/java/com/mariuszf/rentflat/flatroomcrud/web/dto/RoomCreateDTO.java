package com.mariuszf.rentflat.flatroomcrud.web.dto;

import javax.validation.constraints.NotNull;

public class RoomCreateDTO {

    @NotNull private Double surface;
    @NotNull private Long flatId;

    public RoomCreateDTO(@NotNull Double surface, @NotNull Long flatId) {
        this.surface = surface;
        this.flatId = flatId;
    }

    public RoomCreateDTO() {
    }

    public Double getSurface() {
        return surface;
    }

    public Long getFlatId() {
        return flatId;
    }
}
