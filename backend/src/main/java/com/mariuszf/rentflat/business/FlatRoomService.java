package com.mariuszf.rentflat.business;

import com.mariuszf.rentflat.database.FlatEntity;
import com.mariuszf.rentflat.database.FlatRepository;
import com.mariuszf.rentflat.database.RoomEntity;
import com.mariuszf.rentflat.database.RoomRepository;
import com.mariuszf.rentflat.web.dto.FlatCostDTO;
import com.mariuszf.rentflat.web.dto.FlatDTO;
import com.mariuszf.rentflat.web.dto.RoomDTO;
import com.mariuszf.rentflat.web.exception.FlatNotFoundException;
import com.mariuszf.rentflat.web.exception.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlatRoomService {

    private FlatRepository flatRepository;
    private RoomRepository roomRepository;

    @Autowired
    public FlatRoomService(FlatRepository flatRepository, RoomRepository roomRepository) {
        this.flatRepository = flatRepository;
        this.roomRepository = roomRepository;
    }

    public FlatDTO getFlatById(Long id) {
        return getFlatEntityById(id).toDto();
    }

    public List<FlatDTO> getAllFlats() {
        return getAllFlatEntities()
                .stream()
                .map(FlatEntity::toDto)
                .collect(Collectors.toList());
    }

    public FlatDTO createFlat(Double cost, Double surface) {
        return flatRepository.save(new FlatEntity(cost, surface)).toDto();
    }

    public FlatDTO updateFlatById(Long id, Double cost, Double surface){
        FlatEntity flatEntity = getFlatEntityById(id);
        flatEntity.setCost(cost);
        flatEntity.setSurface(surface);
        return flatRepository.save(flatEntity).toDto();
    }

    public void deleteFlatById(Long id){
        flatRepository.delete(getFlatEntityById(id));
    }
    public RoomDTO getRoomById(Long id) {
        return getRoomEntityById(id).toDto();
    }

    public List<RoomDTO> getAllRooms(){
        return getAllRoomEntities()
                .stream()
                .map(RoomEntity::toDto)
                .collect(Collectors.toList());
    }

    public RoomDTO createRoom(Double surface, Long flatId){
        FlatEntity flatEntity = getFlatEntityById(flatId);
        RoomEntity roomEntity = roomRepository.save(new RoomEntity(surface, flatEntity));
        return roomEntity.toDto();
    }

    public RoomDTO updateRoomById(Long id, Double surface){
        RoomEntity roomEntity = getRoomEntityById(id);
        roomEntity.setSurface(surface);
        return roomRepository.save(roomEntity).toDto();
    }

    public void deleteRoomById(Long id){
        roomRepository.delete(getRoomEntityById(id));
    }

    public List<FlatCostDTO> getAllFlatsCost() {
        return getAllFlatEntities()
                .stream()
                .map(FlatEntity::toCostDto)
                .collect(Collectors.toList());
    }

    public FlatCostDTO getFlatCostById(Long id) {
        return getFlatEntityById(id).toCostDto();
    }

    private List<FlatEntity> getAllFlatEntities() {
        return flatRepository.findAll();
    }

    private List<RoomEntity> getAllRoomEntities() {
        return roomRepository.findAll();
    }

    private FlatEntity getFlatEntityById(Long id){
        return flatRepository.findById(id).orElseThrow(FlatNotFoundException::new);
    }

    private RoomEntity getRoomEntityById(Long id){
        return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }
}
