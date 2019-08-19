package com.mariuszf.rentflat.web.flat;

public class UpdateFlatDTO {

    private final double cost;
    private final double surface;

    public UpdateFlatDTO(int cost, double surface) {
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
