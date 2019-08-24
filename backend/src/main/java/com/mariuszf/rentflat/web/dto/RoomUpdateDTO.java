package com.mariuszf.rentflat.web.dto;

public class RoomUpdateDTO {

    private double surface;

    public RoomUpdateDTO(double surface) {
        this.surface = surface;
    }

    public double getSurface() {
        return surface;
    }
}
