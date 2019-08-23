package com.mariuszf.rentflat.web.room;

public class UpdateRoomDTO {

    private double surface;

    public UpdateRoomDTO(double surface) {
        this.surface = surface;
    }

    public double getSurface() {
        return surface;
    }
}
