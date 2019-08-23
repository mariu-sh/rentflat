package com.mariuszf.rentflat.buisness;

import com.mariuszf.rentflat.buisness.flat.FlatService;
import com.mariuszf.rentflat.buisness.room.RoomService;
import com.mariuszf.rentflat.database.flat.FlatEntity;
import com.mariuszf.rentflat.database.room.RoomEntity;
import com.mariuszf.rentflat.web.flat.CreateFlatDTO;
import com.mariuszf.rentflat.web.flat.FlatDTO;
import com.mariuszf.rentflat.web.flat.UpdateFlatDTO;
import com.mariuszf.rentflat.web.room.CreateRoomDTO;
import com.mariuszf.rentflat.web.room.RoomDTO;
import com.mariuszf.rentflat.web.room.UpdateRoomDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public FlatDTO updateRoomById(Long id, UpdateFlatDTO updateFlatDTO) {
        return flatService.updateFlatById(id, updateFlatDTO.getCost(), updateFlatDTO.getSurface());
    }

    public RoomDTO createRoom(CreateRoomDTO createRoomDTO) {
        return createRoom(createRoomDTO.getSurface(), createRoomDTO.getCost(), createRoomDTO.getFlatId());
    }

    private RoomDTO createRoom(double surface, double cost, Long flatId){
        FlatEntity flatEntity = flatService.getFlatEntityById(flatId);
        RoomEntity roomEntity = new RoomEntity(surface, cost, flatEntity);
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
        return roomService.updateRoomById(id, updateRoomDTO.getCost(), updateRoomDTO.getSurface());
    }

    public void deleteRoomById(Long id) {
        roomService.deleteRoomById(id);
    }

}
