package com.mariuszf.rentflat.costservice.business;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlatCost {

    private final Long id;
    private final Double cost;
    //private List<RoomCost> rooms;

}
