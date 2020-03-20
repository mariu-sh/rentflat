package com.mariuszf.rentflat.costservice.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlatCostDTO {

    private final Long id;
    private final Double cost;

}
