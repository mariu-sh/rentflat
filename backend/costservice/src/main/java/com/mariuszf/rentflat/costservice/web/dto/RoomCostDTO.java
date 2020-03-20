package com.mariuszf.rentflat.costservice.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RoomCostDTO {

    private final Long id;
    private final Double cost;

}
