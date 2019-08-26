package com.mariuszf.rentflat.buisness;

import com.mariuszf.rentflat.database.FlatEntity;
import com.mariuszf.rentflat.database.FlatRepository;
import com.mariuszf.rentflat.database.RoomEntity;
import com.mariuszf.rentflat.web.dto.FlatDTO;
import com.mariuszf.rentflat.web.exception.FlatNotFoundException;
import com.mariuszf.rentflat.web.dto.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.mariuszf.rentflat.utils.Utils.roundWithPrecision;

@Service
public class FlatService {

    private FlatRepository flatRepository;
    private RoomService roomService;

    @Autowired
    public FlatService(FlatRepository flatRepository, RoomService roomService) {
        this.flatRepository = flatRepository;
        this.roomService = roomService;
    }

    FlatDTO createFlat(double cost, double surface) {
        FlatEntity flatEntity = new FlatEntity(cost, surface);
        saveEntity(flatEntity);
        return buildDTO(flatEntity);
    }

    FlatDTO getFlatById(Long id) {
        return buildDTO(getFlatEntityById(id));
    }

    List<FlatDTO> getFlats() {
        return flatRepository.findAll().stream()
                .map(this::buildDTO)
                .collect(Collectors.toList());
    }

    FlatDTO updateFlatById(Long id, double cost, double surface) {
        FlatEntity flatEntity = getFlatEntityById(id);
        flatEntity.update(cost, surface);
        saveEntity(flatEntity);
        return buildDTO(flatEntity);
    }

    FlatEntity getFlatEntityById(Long id) {
        return flatRepository.findById(id).orElseThrow(FlatNotFoundException::new);
    }

    void deleteFlatById(Long id) {
        flatRepository.delete(getFlatEntityById(id));
    }

    private FlatDTO buildDTO(FlatEntity flatEntity){
        return new FlatDTO(flatEntity.getId(), flatEntity.getCost(), flatEntity.getSurface(),
                flatEntity.getCommonPartSurface(), buildRoomDTOList(flatEntity.getRoomEntityList()));
    }

    private List<RoomDTO> buildRoomDTOList(List<RoomEntity> roomEntityList) {
        return roomEntityList.stream().map(roomService::buildDTO).collect(Collectors.toList());
    }

    void saveEntity(FlatEntity flatEntity) {
        flatRepository.save(flatEntity);
    }

    double getCostPerSurfaceById(Long id) {
        return roundWithPrecision(getFlatEntityById(id).getCostPerSurface(), 2);
    }
}
