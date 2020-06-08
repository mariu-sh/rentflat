package com.mariuszf.rentflat.costservice.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlatCost {

    private Long id;
    private Double cost;
    private Double surface;
    private List<RoomCost> rooms;

}
