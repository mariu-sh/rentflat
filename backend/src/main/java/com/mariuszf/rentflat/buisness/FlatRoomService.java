package com.mariuszf.rentflat.buisness;

import com.mariuszf.rentflat.buisness.flat.FlatService;
import com.mariuszf.rentflat.buisness.room.RoomService;
import com.mariuszf.rentflat.database.flat.FlatEntity;
import com.mariuszf.rentflat.database.room.RoomEntity;
import com.mariuszf.rentflat.web.flat.dto.CreateFlatDTO;
import com.mariuszf.rentflat.web.flat.dto.FlatCostDTO;
import com.mariuszf.rentflat.web.flat.dto.FlatDTO;
import com.mariuszf.rentflat.web.flat.dto.UpdateFlatDTO;
import com.mariuszf.rentflat.web.room.dto.CreateRoomDTO;
import com.mariuszf.rentflat.web.room.dto.RoomCostDTO;
import com.mariuszf.rentflat.web.room.dto.RoomDTO;
import com.mariuszf.rentflat.web.room.dto.UpdateRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatRoomService {

    private FlatService flatService;
    private RoomService roomService;

    @Autowired
    public FlatRoomService(FlatService flatService, RoomService roomService) {
        this.flatService = flatService;
        this.roomService = roomService;
    }

    public FlatDTO createFlat(CreateFlatDTO createFlatDTO) {
        return flatService.createFlat(createFlatDTO.getCost(), createFlatDTO.getSurface());
    }

    public FlatDTO getFlatById(Long id) {
        return flatService.getFlatById(id);
    }

    public List<FlatDTO> getFlats() {
        return flatService.getFlats();
    }

    public FlatDTO updateFlatById(Long id, UpdateFlatDTO updateFlatDTO) {
        return flatService.updateFlatById(id, updateFlatDTO.getCost(), updateFlatDTO.getSurface());
    }

    public void deleteFlatById(Long id) {
        flatService.deleteFlatById(id);
    }

    public RoomDTO createRoom(CreateRoomDTO createRoomDTO) {
        return createRoom(createRoomDTO.getSurface(), createRoomDTO.getFlatId());
    }

    private RoomDTO createRoom(double surface, Long flatId){
        FlatEntity flatEntity = flatService.getFlatEntityById(flatId);
        RoomEntity roomEntity = new RoomEntity(surface, flatEntity);
        flatEntity.addRoom(roomEntity);
        roomService.saveEntity(roomEntity);
        flatService.saveEntity(flatEntity);
        return roomService.buildDTO(roomEntity);
    }

    public RoomDTO getRoomById(Long id) {
        return roomService.getRoomById(id);
    }

    public List<RoomDTO> getRooms() {
        return roomService.getRooms();
    }

    public RoomDTO updateRoomById(Long id, UpdateRoomDTO updateRoomDTO) {
        return roomService.updateRoomById(id, updateRoomDTO.getSurface());
    }

    public void deleteRoomById(Long id) {
        roomService.deleteRoomById(id);
    }

    public List<FlatCostDTO> getFlatsCost() {
        return getFlats().stream()
                .map(FlatDTO::getId)
                .map(this::getFlatCostById)
                .collect(Collectors.toList());
    }

    public FlatCostDTO getFlatCostById(Long id) {
        return new FlatCostDTO(id, flatService.getFlatById(id).getCost(), getRoomsCostByFlatId(id));
    }

    private List<RoomCostDTO> getRoomsCostByFlatId(Long id) {
        return getRoomsCostByRooms(getRoomsByFlatId(id));
    }

    private List<RoomDTO> getRoomsByFlatId(Long id) {
        return getFlatById(id).getRooms();
    }

    public List<RoomCostDTO> getRoomsCost() {
        return getRoomsCostByRooms(getRooms());
    }

    private List<RoomCostDTO> getRoomsCostByRooms(List<RoomDTO> rooms) {
        return rooms.stream()
                .map(RoomDTO::getId)
                .map(this::getRoomCostDTOById)
                .collect(Collectors.toList());
    }

    public RoomCostDTO getRoomCostDTOById(Long id) {
        return new RoomCostDTO(id, getRoomCostValueById(id));
    }

    private double getRoomCostValueById(Long id) {
        return roomService.getRoomCostByIdAndCostPerSurface(
                id,
                flatService.getCostPerSurfaceById(roomService.getFlatIdForRoomById(id))
        );
    }

    public double getCommonPartSurfaceForFlatById(Long id) {
        double roomsSurface = getRoomsByFlatId(id).stream()
                .mapToDouble(RoomDTO::getSurface)
                .sum();
        return getFlatById(id).getSurface() - roomsSurface;
    }
}
