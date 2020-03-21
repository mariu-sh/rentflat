package com.mariuszf.rentflat.flatroomservice.business;

import com.mariuszf.rentflat.flatroomservice.database.RoomEntity;
import com.mariuszf.rentflat.flatroomservice.database.RoomRepository;
import com.mariuszf.rentflat.flatroomservice.web.dto.RoomDTO;
import com.mariuszf.rentflat.flatroomservice.web.exception.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public RoomDTO getRoomById(Long id) {
        return getRoomEntityById(id).toDto();
    }

    @Override
    public List<RoomDTO> getAllRooms(){
        return getAllRoomEntities()
                .stream()
                .map(RoomEntity::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomDTO> getRoomsByFlatId(Long flatId) {
        return roomRepository.findAllByFlatId(flatId)
                .stream()
                .map(RoomEntity::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public RoomDTO createRoom(Double surface, Long flatId){
        return roomRepository.save(new RoomEntity(surface, flatId)).toDto();
    }

    @Override
    public RoomDTO updateRoomById(Long id, Double surface) {
        RoomEntity roomEntity = getRoomEntityById(id);
        roomEntity.setSurface(surface);
        return roomRepository.save(roomEntity).toDto();
    }

    @Override
    public void deleteRoomById(Long id){
        roomRepository.delete(getRoomEntityById(id));
    }

    private List<RoomEntity> getAllRoomEntities() {
        return roomRepository.findAll();
    }

    private RoomEntity getRoomEntityById(Long id){
        return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

}
