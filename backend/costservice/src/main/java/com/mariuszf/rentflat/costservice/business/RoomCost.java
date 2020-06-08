package com.mariuszf.rentflat.costservice.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomCost {

    private Long id;
    private Double cost;
    private Double surface;

}
