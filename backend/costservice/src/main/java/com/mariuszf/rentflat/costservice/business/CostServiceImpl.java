package com.mariuszf.rentflat.costservice.business;

import com.mariuszf.rentflat.costservice.dataaccess.CostDataAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostServiceImpl implements CostService {

    private CostDataAccess costDataAccess;

    @Autowired
    public CostServiceImpl(CostDataAccess costDataAccess) {
        this.costDataAccess = costDataAccess;
    }

    public FlatCost getFlatCostById(Long id) {
        FlatCost flatCost = costDataAccess.getFlatCostById(id);
        flatCost.setRooms(costDataAccess.getRoomsByFlatId(id));

        calculateCostForRoomsInFlat(flatCost);

        return flatCost;
    }

    private void calculateCostForRoomsInFlat(FlatCost flatCost) {
        Integer roomsAmount = flatCost.getRooms().size();
        Double commonPartSurface = calculateCommonPartSurface(flatCost);
        double costPerSurface = calculateCostPerSurface(flatCost);

        for(RoomCost room: flatCost.getRooms()){
            room.setCost(RoundValue.COST.roundValue(
                    costPerSurface*(room.getSurface() + (commonPartSurface/roomsAmount))
            ));
        }
    }

    private double calculateCostPerSurface(FlatCost flatCost) {
        return flatCost.getCost()/flatCost.getSurface();
    }

    private Double calculateCommonPartSurface(FlatCost flatCost) {
        return flatCost.getSurface()
                - flatCost.getRooms()
                    .stream()
                    .mapToDouble(RoomCost::getSurface)
                    .sum();
    }

}
