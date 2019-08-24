package com.mariuszf.rentflat.web.dto;

public class FlatUpdateDTO {

    private final double cost;
    private final double surface;

    public FlatUpdateDTO(int cost, double surface) {
        this.cost = cost;
        this.surface = surface;
    }

    public double getCost() {
        return cost;
    }

    public double getSurface() {
        return surface;
    }

}
