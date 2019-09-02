package com.mariuszf.rentflat.buisness;

import com.mariuszf.rentflat.database.RoomEntity;
import com.mariuszf.rentflat.database.RoomRepository;
import com.mariuszf.rentflat.web.dto.RoomDTO;
import com.mariuszf.rentflat.web.exception.RoomNotFoundException;
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

    List<RoomDTO> getRooms() {
        return roomRepository.findAll().stream()
                .map(this::buildDTO)
                .collect(Collectors.toList());
    }

    RoomDTO updateRoomById(Long id, double surface) {
        RoomEntity roomEntity = getRoomEntityById(id);
        roomEntity.update(surface);
        saveRoom(roomEntity);
        return buildDTO(roomEntity);
    }

    RoomDTO getRoomById(Long id) {
        return buildDTO(getRoomEntityById(id));
    }

    void deleteRoomById(Long id) {
        roomRepository.delete(getRoomEntityById(id));
    }

    RoomDTO buildDTO(RoomEntity roomEntity) {
        return new RoomDTO(roomEntity.getId(), roomEntity.getSurface());
    }

    RoomEntity saveRoom(RoomEntity roomEntity) {
        return roomRepository.save(roomEntity);
    }

    double getRoomCostById(Long id) {
        return getRoomEntityById(id).getCost();
    }
}
