package com.mariuszf.rentflat.web.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RoomDTO {

    private final long id;
    private final BigDecimal surface;

    public RoomDTO(long id, double surface) {
        this.id = id;
        this.surface = new BigDecimal(surface).setScale(2, RoundingMode.CEILING);
    }

    public long getId() {
        return id;
    }

    public BigDecimal getSurface() {
        return surface;
    }
}
