package com.mariuszf.rentflat.web.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FlatDTO {

    private final long id;
    private final BigDecimal cost;
    private final BigDecimal surface;
    private final BigDecimal commonPartSurface;
    private final List<RoomDTO> rooms;

    public FlatDTO(long id, double cost, double surface, double commonPartSurface, List<RoomDTO> rooms) {
        this.id = id;
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.CEILING);
        this.surface = new BigDecimal(surface).setScale(2, RoundingMode.CEILING);
        this.commonPartSurface = new BigDecimal(commonPartSurface).setScale(2, RoundingMode.CEILING);
        this.rooms = rooms;
    }

    public long getId() {
        return id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getSurface() {
        return surface;
    }

    public List<RoomDTO> getRooms() {
        return rooms;
    }

    public BigDecimal getCommonPartSurface() {
        return commonPartSurface;
    }
}
