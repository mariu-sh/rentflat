package com.mariuszf.rentflat.web.dto;

public class FlatUpdateDTO {

    private double cost;
    private double surface;

    public FlatUpdateDTO(int cost, double surface) {
        this.cost = cost;
        this.surface = surface;
    }

    public FlatUpdateDTO() {
    }

    public double getCost() {
        return cost;
    }

    public double getSurface() {
        return surface;
    }



}
