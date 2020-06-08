package com.mariuszf.rentflat.costservice.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FlatCostDTO {

    private final Long id;
    private final Double cost;
    private final List<RoomCostDTO> rooms;

}
