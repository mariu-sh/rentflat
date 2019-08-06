package com.mariuszf.rentflat.buisness;

import com.mariuszf.rentflat.database.FlatRepository;
import com.mariuszf.rentflat.web.FlatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlatService {

    private FlatRepository flatRepository;

    @Autowired
    public FlatService(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    public FlatDTO createDefaultFlat() {
        return this.createFlat(251251, 123.1, 4);
    }

    public FlatDTO createFlat(int cost, double totalSurface, int roomsAmount) {
        FlatEntity flatEntity = new FlatEntity(cost, totalSurface, roomsAmount);
        return flatRepository.save(flatEntity).buildDTO();
    }

}
