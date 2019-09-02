package com.mariuszf.rentflat.web.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class FlatCostDTO {

    private final Long id;
    private final BigDecimal cost;
    private final BigDecimal calculatedCost;
    private final List<RoomCostDTO> rooms;

    public FlatCostDTO(Long id, double cost, List<RoomCostDTO> rooms) {
        this.id = id;
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.CEILING);
        this.rooms = rooms;
        this.calculatedCost = summarizeRoomsCost();
    }

    private BigDecimal summarizeRoomsCost() {
        double value = rooms.stream()
                .map(RoomCostDTO::getCost)
                .mapToDouble(BigDecimal::doubleValue)
                .sum();
        return new BigDecimal(value).setScale(2, RoundingMode.CEILING);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public List<RoomCostDTO> getRooms() {
        return rooms;
    }

    public BigDecimal getCalculatedCost() {
        return calculatedCost;
    }
}
