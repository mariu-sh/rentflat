package com.mariuszf.rentflat.buisness;

import com.mariuszf.rentflat.database.RoomEntity;
import com.mariuszf.rentflat.web.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public FlatDTO createFlat(FlatCreateDTO flatCreateDTO) {
        return flatService.createFlat(flatCreateDTO.getCost(), flatCreateDTO.getSurface());
    }

    public FlatDTO getFlatById(Long id) {
        return flatService.getFlatById(id);
    }

    public List<FlatDTO> getFlats() {
        return flatService.getFlats();
    }

    public FlatDTO updateFlatById(Long id, FlatUpdateDTO flatUpdateDTO) {
        return flatService.updateFlatById(id, flatUpdateDTO.getCost(), flatUpdateDTO.getSurface());
    }

    public void deleteFlatById(Long id) {
        flatService.deleteFlatById(id);
    }

    @Transactional
    public RoomDTO createRoom(RoomCreateDTO roomCreateDTO) {
        return createRoom(roomCreateDTO.getSurface(), roomCreateDTO.getFlatId());
    }

    private RoomDTO createRoom(double surface, Long flatId){
        return roomService.buildDTO(
                roomService.saveRoom(
                        new RoomEntity(surface, flatService.getFlatEntityById(flatId))
                )
        );
    }

    public RoomDTO getRoomById(Long id) {
        return roomService.getRoomById(id);
    }

    public List<RoomDTO> getRooms() {
        return roomService.getRooms();
    }

    public RoomDTO updateRoomById(Long id, RoomUpdateDTO roomUpdateDTO) {
        return roomService.updateRoomById(id, roomUpdateDTO.getSurface());
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
        return new FlatCostDTO(id,
                flatService.getFlatById(id).getCost().doubleValue(),
                getRoomsCostByFlatId(id));
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
        return roomService.getRoomCostById(id);
    }
}
