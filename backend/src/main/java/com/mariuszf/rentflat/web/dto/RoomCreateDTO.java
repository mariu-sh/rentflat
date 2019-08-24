package com.mariuszf.rentflat.web.dto;

public class RoomCreateDTO {

    private double surface;
    private Long flatId;

    public RoomCreateDTO(double surface, Long flatId) {
        this.surface = surface;
        this.flatId = flatId;
    }

    public double getSurface() {
        return surface;
    }

    public Long getFlatId() {
        return this.flatId;
    }
}
