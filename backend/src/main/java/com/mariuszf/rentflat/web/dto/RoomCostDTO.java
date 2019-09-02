package com.mariuszf.rentflat.web.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoomCostDTO {

    private final long id;
    private final BigDecimal cost;

    public RoomCostDTO(long id, double cost) {
        this.id = id;
        this.cost = new BigDecimal(cost).setScale(2, RoundingMode.CEILING);
    }

    public long getId() {
        return id;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
