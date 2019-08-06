package com.mariuszf.rentflat.buisness;

import org.springframework.stereotype.Service;

@Service
public class FlatService {

    public FlatEntity createDefaultFlat() {
        return this.createFlat(251251, 123.1, 4);
    }

    public FlatEntity createFlat(int cost, double totalSurface, int roomsAmount) {
        return new FlatEntity(cost, totalSurface, roomsAmount);
    }

}
