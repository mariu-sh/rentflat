package com.mariuszf.rentflat.web.room.dto;

public class CreateRoomDTO {

    private double surface;
    private Long flatId;

    public CreateRoomDTO(double surface, Long flatId) {
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
