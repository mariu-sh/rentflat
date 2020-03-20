package com.mariuszf.rentflat.costservice.business;

import org.springframework.stereotype.Service;

@Service
public class CostService {

    public FlatCost getFlatCostById(Long id) {
        return new FlatCost(id, 123.4);
    }
}
