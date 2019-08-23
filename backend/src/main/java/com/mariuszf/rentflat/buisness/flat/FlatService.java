package com.mariuszf.rentflat.buisness.flat;

import com.mariuszf.rentflat.buisness.room.RoomService;
import com.mariuszf.rentflat.database.flat.FlatEntity;
import com.mariuszf.rentflat.database.flat.FlatRepository;
import com.mariuszf.rentflat.database.room.RoomEntity;
import com.mariuszf.rentflat.web.flat.FlatDTO;
import com.mariuszf.rentflat.web.flat.FlatNotFoundException;
import com.mariuszf.rentflat.web.room.RoomDTO;
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

    public FlatEntity getFlatEntityById(Long id) {
        return flatRepository.findById(id).orElseThrow(FlatNotFoundException::new);
    }

    public FlatDTO createFlat(double cost, double surface) {
        FlatEntity flatEntity = new FlatEntity(cost, surface);
        saveEntity(flatEntity);
        return buildDTO(flatEntity);
    }

    public FlatDTO getFlatById(Long id) {
        return buildDTO(getFlatEntityById(id));
    }

    public List<FlatDTO> getFlats() {
        return flatRepository.findAll().stream()
                .map(this::buildDTO)
                .collect(Collectors.toList());
    }

    public FlatDTO updateFlatById(Long id, double cost, double surface) {
        FlatEntity flatEntity = getFlatEntityById(id);
        flatEntity.update(cost, surface);
        saveEntity(flatEntity);
        return buildDTO(flatEntity);
    }

    public void deleteFlatById(Long id) {
        flatRepository.deleteById(id);
    }

    private FlatDTO buildDTO(FlatEntity flatEntity){
        return new FlatDTO(flatEntity.getId(), flatEntity.getCost(), flatEntity.getSurface(),
                buildRoomDTOList(flatEntity.getRoomEntityList()));
    }

    private List<RoomDTO> buildRoomDTOList(List<RoomEntity> roomEntityList) {
        return roomEntityList.stream().map(roomService::buildDTO).collect(Collectors.toList());
    }

    public void saveEntity(FlatEntity flatEntity) {
        flatRepository.save(flatEntity);
    }

    public double getCostPerSurfaceById(Long id) {
        return roundWithPrecision(getFlatEntityById(id).getCostPerSurface(), 2);
    }
}
