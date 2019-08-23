package com.mariuszf.rentflat.buisness.room;

import com.mariuszf.rentflat.database.room.RoomEntity;
import com.mariuszf.rentflat.database.room.RoomRepository;
import com.mariuszf.rentflat.web.room.RoomDTO;
import com.mariuszf.rentflat.web.room.RoomNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    private RoomEntity getRoomEntityById(Long id) {
        return roomRepository.findById(id).orElseThrow(RoomNotFoundException::new);
    }

    public List<RoomDTO> getRooms() {
        return roomRepository.findAll().stream()
                .map(this::buildDTO)
                .collect(Collectors.toList());
    }

    public RoomDTO updateRoomById(Long id, double cost, double surface) {
        RoomEntity roomEntity = getRoomEntityById(id);
        roomEntity.update(cost, surface);
        roomRepository.save(roomEntity);
        return buildDTO(roomEntity);
    }

    public RoomDTO getRoomById(Long id) {
        return buildDTO(getRoomEntityById(id));
    }

    public void deleteRoomById(Long id) {
        roomRepository.delete(getRoomEntityById(id));
    }

    public RoomDTO buildDTO(RoomEntity roomEntity) {
        return new RoomDTO(roomEntity.getId(), roomEntity.getSurface(), roomEntity.getCost());
    }

    public void saveEntity(RoomEntity roomEntity) {
        roomRepository.save(roomEntity);
    }
}
