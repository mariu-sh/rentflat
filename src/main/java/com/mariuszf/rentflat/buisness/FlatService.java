package com.mariuszf.rentflat.buisness;

import com.mariuszf.rentflat.database.FlatRepository;
import com.mariuszf.rentflat.web.CreateFlatDTO;
import com.mariuszf.rentflat.web.FlatDTO;
import com.mariuszf.rentflat.web.FlatNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlatService {

    private FlatRepository flatRepository;

    @Autowired
    public FlatService(FlatRepository flatRepository) {
        this.flatRepository = flatRepository;
    }

    public FlatDTO createFlat(CreateFlatDTO createFlatDTO) {
        return createFlat(createFlatDTO.getCost(), createFlatDTO.getTotalSurface(), createFlatDTO.getRoomsAmount());
    }

    private FlatDTO createFlat(int cost, double totalSurface, int roomsAmount) {
        FlatEntity flatEntity = new FlatEntity(cost, totalSurface, roomsAmount);
        return flatRepository.save(flatEntity).buildDTO();
    }

    public FlatDTO getFlatById(Long id) {
        Optional<FlatEntity> flatEntity = flatRepository.findById(id);
        Optional<FlatDTO> flatDTO = flatEntity.map(FlatEntity::buildDTO);
        return flatDTO.orElseThrow(FlatNotFoundException::new);
    }

    public List<FlatDTO> getFlats() {
        return flatRepository.findAll().stream()
                .map(FlatEntity::buildDTO)
                .collect(Collectors.toList());
    }
}
