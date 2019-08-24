package com.mariuszf.rentflat.web.dto;

public class RoomDTO {

    private final long id;
    private double surface;

    public RoomDTO(long id, double surface) {
        this.id = id;
        this.surface = surface;
    }

    public long getId() {
        return id;
    }

    public double getSurface() {
        return surface;
    }
}
