package com.mariuszf.rentflat.costservice.business;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@AllArgsConstructor
public enum RoundValue {
    COST(2, RoundingMode.UP);

    private Integer precision;
    private RoundingMode roundingMode;

    public Double getValueWithPrecision(Double value){
        return new BigDecimal(value).setScale(precision, roundingMode).doubleValue();
    }
}
