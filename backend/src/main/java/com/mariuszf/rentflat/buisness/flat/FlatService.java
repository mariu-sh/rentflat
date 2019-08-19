package com.mariuszf.rentflat.buisness.flat;

import com.mariuszf.rentflat.buisness.room.RoomService;
import com.mariuszf.rentflat.database.flat.FlatRepository;
import com.mariuszf.rentflat.web.flat.CreateFlatDTO;
import com.mariuszf.rentflat.web.flat.FlatDTO;
import com.mariuszf.rentflat.web.flat.FlatNotFoundException;
import com.mariuszf.rentflat.web.flat.UpdateFlatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlatService {

    private FlatRepository flatRepository;
    private RoomService roomService;

    @Autowired
    public FlatService(FlatRepository flatRepository, RoomService roomService) {
        this.flatRepository = flatRepository;
        this.roomService = roomService;
    }

    public FlatDTO createFlat(CreateFlatDTO createFlatDTO) {
        return createFlat(createFlatDTO.getCost(), createFlatDTO.getSurface());
    }

    private FlatDTO createFlat(double cost, double totalSurface) {
        FlatEntity flatEntity = new FlatEntity(cost, totalSurface);
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

    public FlatDTO updateFlatById(Long id, UpdateFlatDTO updateFlatDTO) {
        FlatEntity flatEntity = flatRepository.findById(id).orElseThrow(FlatNotFoundException::new);
        flatEntity.update(updateFlatDTO);
        return flatRepository.save(flatEntity).buildDTO();
    }

    public void deleteFlatById(Long id) {
        flatRepository.deleteById(id);
    }
}
