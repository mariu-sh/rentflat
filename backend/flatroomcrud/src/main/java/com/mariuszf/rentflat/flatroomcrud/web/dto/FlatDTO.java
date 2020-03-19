package com.mariuszf.rentflat.flatroomcrud.web.dto;

public class FlatDTO {

    private final Long id;
    private final String uuid;
    private final Double surface;
    private final Double cost;

    public FlatDTO(Long id, String uuid, Double surface, Double cost) {
        this.id = id;
        this.uuid = uuid;
        this.surface = surface;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public Double getSurface() {
        return surface;
    }

    public Double getCost() {
        return cost;
    }
}
