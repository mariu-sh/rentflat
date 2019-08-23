package com.mariuszf.rentflat.buisness.flat;

import com.mariuszf.rentflat.buisness.room.RoomService;
import com.mariuszf.rentflat.database.flat.FlatEntity;
import com.mariuszf.rentflat.database.flat.FlatRepository;
import com.mariuszf.rentflat.database.room.RoomEntity;
import com.mariuszf.rentflat.web.flat.CreateFlatDTO;
import com.mariuszf.rentflat.web.flat.FlatDTO;
import com.mariuszf.rentflat.web.flat.FlatNotFoundException;
import com.mariuszf.rentflat.web.flat.UpdateFlatDTO;
import com.mariuszf.rentflat.web.room.RoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    private FlatEntity getFlatEntityById(Long id) {
        return flatRepository.findById(id).orElseThrow(FlatNotFoundException::new);
    }

    public FlatDTO createFlat(CreateFlatDTO createFlatDTO) {
        return createFlat(createFlatDTO.getCost(), createFlatDTO.getSurface());
    }

    private FlatDTO createFlat(double cost, double surface) {
        FlatEntity flatEntity = new FlatEntity(cost, surface);
        flatRepository.save(flatEntity);
        return buildDTO(flatEntity);
    }

    public FlatDTO getFlatDTOById(Long id) {
        return buildDTO(getFlatEntityById(id));
    }

    public List<FlatDTO> getFlatDTOList() {
        return flatRepository.findAll().stream()
                .map(this::buildDTO)
                .collect(Collectors.toList());
    }

    public FlatDTO updateFlatById(Long id, UpdateFlatDTO updateFlatDTO) {
        return updateFlatById(id, updateFlatDTO.getCost(), updateFlatDTO.getSurface());
    }

    public FlatDTO updateFlatById(Long id, double cost, double surface) {
        FlatEntity flatEntity = getFlatEntityById(id);
        flatEntity.update(cost, surface);
        flatRepository.save(flatEntity);
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
}
