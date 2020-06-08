package com.mariuszf.rentflat.costservice.dataaccess;

import com.mariuszf.rentflat.costservice.business.FlatCost;
import com.mariuszf.rentflat.costservice.business.RoomCost;

import java.util.List;

public interface CostDataAccess {

    FlatCost getFlatCostById(Long id);

    List<RoomCost> getRoomsByFlatId(Long id);
}
